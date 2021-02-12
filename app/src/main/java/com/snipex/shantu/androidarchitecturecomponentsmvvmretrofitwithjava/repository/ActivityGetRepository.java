package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.GetApiResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ApiRequest;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityGetRepository {
    private static final String TAG = ActivityGetRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public ActivityGetRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance3().create(ApiRequest.class);
    }

    public LiveData<GetApiResponse> getAndroidList (){
        final MutableLiveData<GetApiResponse> data = new MutableLiveData<>();
        apiRequest.getAndroidList()
                .enqueue(new Callback<GetApiResponse>() {
                    @Override
                    public void onResponse(Call<GetApiResponse> call, Response<GetApiResponse> response) {
                        Log.e(TAG, "onResponse response:: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());

                        }
                    }
                    @Override
                    public void onFailure(Call<GetApiResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
