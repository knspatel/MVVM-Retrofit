package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.utils;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class AppUtils {

//    public boolean haveNetwork(){
//        boolean have_WIFI= false;
//        boolean have_MobileData = false;
//        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
//        for(NetworkInfo info:networkInfos){
//            if (info.getTypeName().equalsIgnoreCase("WIFI"))if (info.isConnected())have_WIFI=true;
//            if (info.getTypeName().equalsIgnoreCase("MOBILE DATA"))if (info.isConnected())have_MobileData=true;
//        }
//        return have_WIFI||have_MobileData;
//    }
}
