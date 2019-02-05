package com.walton.retrofitexample.ApiInterface;



import com.walton.retrofitexample.Coins;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface LUsersApi {


  /*  @Headers({
            "Authorization", "Bearer "+ "OkM_9V_ilZ4Phaqwcjv2rs25HsOt7Qco"
    })
*/
    @GET("api.pandanews.pro/coin")
    Call<Coins> getCoins(@Body String id);



/*

    @GET("api.pandanews.pro/coin")
*/

/*
    @Headers("Content-Type: application/json")
    @POST("/salesAPIdev/api/login")
    Call<Users> getUsers(@Body String login);*/

}