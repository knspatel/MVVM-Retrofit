package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Post;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ArticleRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.PostRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.PostResponse;

import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.API_KEY;
import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.ARTICLE_QUERY;

public class PostViewModel extends AndroidViewModel {

    private PostRepository postRepository;
    private LiveData<Post> postResponseLiveData;

    public PostViewModel(@NonNull Application application) {
        super(application);

        postRepository = new PostRepository();
//
//        this.postResponseLiveData =
//                postRepository.sendPostData(ARTICLE_QUERY, API_KEY);
    }

    public void  setPostData(Post mPost){

        this.postResponseLiveData =
                postRepository.sendPostData(mPost);
    }

    public LiveData<Post> getPostResponseLiveData() {
        return postResponseLiveData;
    }
}
