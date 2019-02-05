package com.walton.retrofitexample.ApiInterface;



import com.walton.retrofitexample.Coins;
import com.walton.retrofitexample.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IUsersApi  {


    @Headers("Authorization")
    @GET("coin")
 // Call<User> getUser(@Body String login);
    Call<Coins> getCoins(@Body String login);


    /*Call<UserProfile> getUser(@Path("id") String id);*/
   Call<User>createUser(@Header("Authorization") String token,
                        @Body String login);

}