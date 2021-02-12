package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.BASE_URL;
import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.BASE_URL2;
import static com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants.AppConstant.BASE_URL3;

public class RetrofitRequest {

    private static Retrofit retrofit , retrofit2 ,retrofit3;


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitInstance3() {
        if (retrofit3 == null) {
            retrofit3 = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL3)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit3;
    }


    public static Retrofit getRetrofitInstancePost() {
       if (retrofit2 == null) {
            retrofit2 = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL2)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
       }
        return retrofit2;
    }
}
