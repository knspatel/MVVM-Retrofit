package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Post;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.GetApiResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("v2/everything/")
    Call<ArticleResponse> getMovieArticles(
            @Query("q") String query,
            @Query("apikey") String apiKey
    );

    @POST("posts")
    @Headers({"Content-type: application/json"})
    //@FormUrlEncoded
    Call<Post> savePost(@Body Post posts
                        //@Field("title") String title,
                       // @Field("body") String body,
                      //  @Field("userId") long userId
                        );


    @GET("android/jsonandroid")
    Call<GetApiResponse> getAndroidList(
          );
}
