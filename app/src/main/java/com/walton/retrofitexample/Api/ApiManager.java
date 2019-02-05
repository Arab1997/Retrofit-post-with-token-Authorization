package com.walton.retrofitexample.Api;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.walton.retrofitexample.Activity.SharedPreference;
import com.walton.retrofitexample.ApiInterface.IUsersApi;
import com.walton.retrofitexample.ApiInterface.LUsersApi;
//import com.walton.retrofitexample.SharedPrefManager;
import com.walton.retrofitexample.Coins;
import com.walton.retrofitexample.User;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiManager {
    private static LUsersApi services;
    private static IUsersApi service;
    private static ApiManager apiManager;
    private Context mContext;
    private String token;

    private ApiManager() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "OkM_9V_ilZ4Phaqwcjv2rs25HsOt7Qco")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.pandanews.pro/")
                .addConverterFactory( ScalarsConverterFactory.create() )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
/*

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl( "http://192.168...../" )
                .baseUrl( "https://api.pandanews.pro/coin" )
                .addConverterFactory( ScalarsConverterFactory.create() )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();
        */

        service = retrofit.create( IUsersApi.class );

        services = retrofit.create( LUsersApi.class );



    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;

    }


    public void createUser(JSONObject login,String valuetoken,Callback<User> callback) {

       String getPreferencee=SharedPreference.getStringValue( mContext,SharedPreference.ACCESS_KEY );
       Log.e("access get value",getPreferencee);

      token = "Bearer "+SharedPreference.getStringValue( mContext,SharedPreference.ACCESS_KEY );
      String sharedAccessKey = SharedPreference.getStringValue( mContext, SharedPreference.ACCESS_KEY );
        Log.e( "token value ", sharedAccessKey );
      /* "eyJhbGciOiJIUzI1NiJ9.eyJwcmluY2lwYWwiOiJINHNJQUFBQUFBQUFBSlZTTVU4VVFSajlkams4SWdtQ2lTWVUwSWlkMlV1MHZBb1" +
               "FqV1k5RE9jMW1HRG1kalwvV2dkbVpjV1lXN2hwemxSWVVHSVhFeE5hU2Y2S05OU0ZhMkZMYjhzMGVzS2NOY2FySm03ZnZ2ZT" +
               "k5ZTNRSzQ5YkFnOHd3TG15a1JaRnhHVmx0dU13c0pvWGhyaDhWRmsyS3JtUThMb2tkUW1CNGdoQ0NHRUtlT3JnWmI3RWQxaEJNWm" +
               "8zVjdoWW1ydGt6Y0YrWjdGeHgwN0FjZDVYWmppNjFFMlh3TDROS092Z2FRbjBkWmxpU3FFSzZscElyUGMwTnB1c3dYV0d4U3JZOWRDdWh" +
               "GNVNPTTJGSHFYV1VyQ3N3aldHU0ZlNjFJbGVPMXNHTllkakNjZEZvbzJ2R01LR1p0WlR1bjBuYXprZjM3ejZtcEFuZXdGdW85WFJBaDdxNzY2b" +
               "VIxNG1XbFJBME5WZlNMblJrcmxLK3liMDU2UVwvbVB2N1lcL3pMb2hBRFV5YjJydjZudzJTVVlmTnY0TTE4V0hTUU9ibzlFcjJqTm5xWTBNNVh5QzRQ" +
               "ZStlVHo4MCtIcCs5ZmpwR3paeno2XC8zMHNMSjQzMTE5V3VXYUdPVFd5STVMZHJkRTlKUEdscThVdnR0Q1AyanpYQXVtUGtnN1RTNHRLbU1hdEdTVXUrblp3Z" +
               "lcwMVhubTErUERaazViMTRKU0RlZ20xMVwvenpoR1VDTGRPY2dreVZQZmdGUnJHaTllMzlcL3ZCOVwvODVQRW4wSzR6dE1GRWhybUs1SXJTTHZvbmwzZERnM2VmQ" +
               "nJyeHhxR09UYThSbVhBQjE5SkFNQUFBPT0iLCJzdWIiOiJzYWxlc2FwaSIsInJvbGVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1NSIl0sImlzcyI6IlNwcmlu" +
               "ZyBTZWN1cml0eSBSRVNUIEdyYWlscyBQbHVnaW4iLCJleHAiOjE1Mzk4NTUyMzcsImlhdCI6MTUzOTg1MTYzN30.oDaMkTfb8_8VUcodGpCH-_gKx8tTH" +
               "ZvOn9A4kBjCL5k" ;*/

 /*   "Bearer OkM_9V_ilZ4Phaqwcjv2rs25HsOt7Qco" ;*/

        Log.e( "token value", token );

        Call<User> loginCall = service.createUser(String.valueOf(valuetoken), String.valueOf( login ) );
        loginCall.enqueue( callback );
    }


    public void getCoins(JSONObject login, Callback<Coins> callback) {
        Call<Coins> loginCall = services.getCoins( String.valueOf( login ) );
        loginCall.enqueue( callback );
    }
}
