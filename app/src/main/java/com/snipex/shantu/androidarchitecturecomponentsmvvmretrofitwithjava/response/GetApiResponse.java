package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Android;

import java.util.List;

public class GetApiResponse {
    @SerializedName("android")
    @Expose
    private List<Android> android = null;

    public List<Android> getAndroid() {
        return android;
    }

    public void setAndroid(List<Android> android) {
        this.android = android;
    }

}
