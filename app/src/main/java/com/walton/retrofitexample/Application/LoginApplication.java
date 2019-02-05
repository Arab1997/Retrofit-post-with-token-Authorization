package com.walton.retrofitexample.Application;

import android.app.Application;

import com.walton.retrofitexample.Api.ApiManager;

public class LoginApplication extends Application {

    public static ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance();
    }
}
