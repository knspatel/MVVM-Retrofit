package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.adapter.ActivityGetAdapter;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Android;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model.ActivityGetViewModel;

import java.util.ArrayList;
import java.util.List;

public class ActivityGet extends AppCompatActivity {
    ActivityGetViewModel vm;
    private RecyclerView my_recycler_view;
    private ProgressBar progress_circular_movie_article;
    private LinearLayoutManager layoutManager;
    private ActivityGetAdapter adapter;
    private ArrayList<Android> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        initialization();
        getApiCall();
    }

    private void initialization() {

        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(ActivityGet.this);
        my_recycler_view.setLayoutManager(layoutManager);
        my_recycler_view.setHasFixedSize(true);

        // adapter
        adapter = new ActivityGetAdapter(ActivityGet.this, mList);
        my_recycler_view.setAdapter(adapter);



        vm = ViewModelProviders.of(this).get(ActivityGetViewModel.class);

    }

    private void getApiCall() {
        vm.getActivityData().observe(this, mResponse -> {
            if (mResponse != null) {
                Log.e("TAG", "getApiCall: "+mResponse.getAndroid().toString() );
                progress_circular_movie_article.setVisibility(View.GONE);
                List<Android> mList2 = mResponse.getAndroid();
                mList.addAll(mList2);
                adapter.notifyDataSetChanged();

            }
        });
    }

}
