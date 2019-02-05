package com.walton.retrofitexample.Application;

import android.app.Application;

import com.walton.retrofitexample.Api.ApiManager;

public class MainApplication extends LoginApplication
{

    public static ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance();
    }
}
