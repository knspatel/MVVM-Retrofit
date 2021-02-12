package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.MovieArticleAdapter;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.AppDatabase;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.DatabaseClient;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView my_recycler_view;
    private ProgressBar progress_circular_movie_article;
    private LinearLayoutManager layoutManager;
    private MovieArticleAdapter adapter;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       db =   DatabaseClient.getInstance(this).getAppDatabase();

        initialization();

        getMovieArticles();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.api_calls:
                startActivity(new Intent(this, ActivitySendPost.class));
                return true;

            case R.id.grid:
                startActivity(new Intent(this, GifActivity.class));
                return true;

            case R.id.get:
                startActivity(new Intent(this, ActivityGet.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private void initialization() {
        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);

        // adapter
        adapter = new MovieArticleAdapter(MainActivity.this, articleArrayList);
        my_recycler_view.setAdapter(adapter);

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }

    /**
     * get movies articles from news api
     *
     * @param @null
     */
    private void getMovieArticles() {
        if(haveNetwork()){
            Log.e(TAG, "getMovieArticles: yes>>>>>" );
            articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
                if (articleResponse != null) {
                    Log.e(TAG, "getMovieArticles: >>>>>>>>>>>>>>>>>" );
                    progress_circular_movie_article.setVisibility(View.GONE);
                    List<Article> articles = articleResponse.getArticles();
                    articleArrayList.addAll(articles);
                    adapter.notifyDataSetChanged();

                    SaveTask st = new SaveTask();
                    st.execute();
                }
            });

        }else{
            Log.e(TAG, "getMovieArticles: No >>>>>>>" );
            getTasks();
        }
    }

    class SaveTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
          for (int i = 0; i < articleArrayList.size(); i++) {
                    //insert data in db
                    Article article = new Article();
                    article.setTitle(articleArrayList.get(i).getTitle());
                    article.setAuthor(articleArrayList.get(i).getAuthor());
                    article.setUrlToImage(articleArrayList.get(i).getUrlToImage());
                    article.setPublishedAt(articleArrayList.get(i).getPublishedAt());
                    article.setDescription(articleArrayList.get(i).getDescription());

                    db.articleDao().insert(article);
                }
            //adding to database
//            DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
//                    .taskDao()
//                    .insert(task);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        }
    }


    private void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<Article>> {

            @Override
            protected List<Article> doInBackground(Void... voids) {
                List<Article> articleList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .articleDao()
                        .getAll();
                return articleList;
            }

            @Override
            protected void onPostExecute(List<Article> articles) {
                super.onPostExecute(articles);
                //TasksAdapter adapter = new TasksAdapter(MainActivity.this, tasks);
               // recyclerView.setAdapter(adapter);
                articleArrayList.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }

    private boolean haveNetwork(){
        boolean have_WIFI= false;
        boolean have_MobileData = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
        for(NetworkInfo info:networkInfos){
            if (info.getTypeName().equalsIgnoreCase("WIFI"))if (info.isConnected())have_WIFI=true;
            if (info.getTypeName().equalsIgnoreCase("MOBILE DATA"))if (info.isConnected())have_MobileData=true;
        }
        return have_WIFI||have_MobileData;
    }
}
