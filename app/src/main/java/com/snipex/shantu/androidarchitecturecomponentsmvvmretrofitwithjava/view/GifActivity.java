package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.ImageGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class GifActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ProgressBar progress_circular_movie_article;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        rv = findViewById(R.id.my_recycler_view);
        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);


        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(sglm);

        List<String> imageList = new ArrayList<>();
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Rotating_earth_%28large%29.gif/200px-Rotating_earth_%28large%29.gif");
        imageList.add("https://www.thisiscolossal.com/wp-content/uploads/2014/03/120515.gif");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Rotating_earth_%28large%29.gif/200px-Rotating_earth_%28large%29.gif");
        imageList.add("https://buffer.com/library/content/images/library/wp-content/uploads/2016/06/giphy.gif");
        imageList.add("https://buffer.com/library/content/images/library/wp-content/uploads/2016/06/giphy.gif");
        imageList.add("https://www.thisiscolossal.com/wp-content/uploads/2014/03/120515.gif");
        imageList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Rotating_earth_%28large%29.gif/200px-Rotating_earth_%28large%29.gif");

        ImageGridAdapter iga = new ImageGridAdapter(GifActivity.this, imageList);
        rv.setAdapter(iga);
        iga.notifyDataSetChanged();


        progress_circular_movie_article.setVisibility(View.GONE);


    }
}
