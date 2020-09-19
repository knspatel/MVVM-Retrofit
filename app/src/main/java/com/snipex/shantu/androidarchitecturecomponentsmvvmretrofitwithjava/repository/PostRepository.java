package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Post;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.PostResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ApiRequest;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private static final String TAG = PostRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public PostRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstancePost().create(ApiRequest.class);
    }

    public LiveData<Post> sendPostData(Post mPost) {


        final MutableLiveData<Post> data = new MutableLiveData<>();
        apiRequest.savePost(mPost)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Log.e(TAG, "onResponse response:: " + response.body().toString());
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
