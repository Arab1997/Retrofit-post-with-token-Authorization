package com.walton.retrofitexample.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.walton.retrofitexample.Api.ApiManager;
import com.walton.retrofitexample.Application.MainApplication;
import com.walton.retrofitexample.Application.LoginApplication;
import com.walton.retrofitexample.Coins;
import com.walton.retrofitexample.R;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;
    private String token;
    private String username = "username";
    private String password = "password";
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        mContext = this;


        usernameEditText = findViewById( R.id.etusername );
        passwordEditText = findViewById( R.id.etpassword );
        loginButton = findViewById( R.id.btnlogin );
        progressBar = findViewById( R.id.progress_bar );

        loginButton.setOnClickListener( this );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:

                try {
                    JSONObject login = new JSONObject();
                  //  login.put( "username", usernameEditText.getText().toString().trim() );
                   // login.put( "password", passwordEditText.getText().toString().trim() );
                    login.put(username, "admin");
                    login.put(password, "1234");

                    progressBar.setVisibility( View.VISIBLE );
                   LoginApplication.apiManager.getCoins( login, new Callback<Coins>() {


                        @Override
                        public void onResponse(Call<Coins> call, Response<Coins> response) {
                            progressBar.setVisibility( View.GONE );
                            Coins responseUser = response.body();
                            if (response.isSuccessful() && responseUser != null) {
                                Toast.makeText( LoginActivity.this,
                                        String.format( "Username %s \n and token type %s \n Access token %s  ",
                                                responseUser.getName(),
                                                responseUser.getId(),
                                                responseUser.getImage_128() ),
                                        Toast.LENGTH_LONG )
                                        .show();
                                token = responseUser.getImage_128();
                                SharedPreference.setStringValue( mContext,SharedPreference.ACCESS_KEY,token);
                             String getString=SharedPreference.getStringValue( mContext,SharedPreference.ACCESS_KEY );
                                Log.e( "token set value",token );


                                Intent i = new Intent( getApplicationContext(), MainApplication.class );
                                startActivity( i );

                                Intent ii = new Intent(LoginActivity.this, CreateuserActivity.class);
                                String valuetoken="Bearer "+SharedPreference.getStringValue( mContext,SharedPreference.ACCESS_KEY );
                                Log.e( "token get value",valuetoken );
                               ii.putExtra("token", valuetoken);


                            } else {
                                Toast.makeText( LoginActivity.this,
                                        String.format( "Response is %s", String.valueOf( response.code() ) )
                                        , Toast.LENGTH_LONG ).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Coins> call, Throwable t) {
                            progressBar.setVisibility( View.GONE );
                            Toast.makeText( LoginActivity.this,
                                    "Error is " + t.getMessage()
                                    , Toast.LENGTH_LONG ).show();
                        }
                    } );


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}