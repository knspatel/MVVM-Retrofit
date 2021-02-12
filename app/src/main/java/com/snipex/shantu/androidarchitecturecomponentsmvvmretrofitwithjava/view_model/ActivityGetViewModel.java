package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ActivityGetRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ArticleRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.GetApiResponse;

import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.API_KEY;
import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.ARTICLE_QUERY;

public class ActivityGetViewModel extends AndroidViewModel {

    private ActivityGetRepository mRepository;
    private LiveData<GetApiResponse> mResponse;

    public ActivityGetViewModel(@NonNull Application application) {
        super(application);

        mRepository = new ActivityGetRepository();
        this.mResponse = mRepository.getAndroidList();
    }

    public LiveData<GetApiResponse> getActivityData() {
        return mResponse;
    }
}
