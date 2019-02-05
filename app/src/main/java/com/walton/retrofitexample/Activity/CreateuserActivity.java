package com.walton.retrofitexample.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.walton.retrofitexample.Application.LoginApplication;
import com.walton.retrofitexample.Application.MainApplication;
import com.walton.retrofitexample.R;
import com.walton.retrofitexample.User;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateuserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText;
    private EditText proprietorNameEditText;
    private EditText presentAddressEditText;
    private EditText shopCategoryEditText;
    private EditText mobilePhoneEditText;
    Context mContext;

    private Button loginButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        nameEditText = findViewById(R.id.etxtname);
        proprietorNameEditText = findViewById(R.id.etxtproprietorName);
        presentAddressEditText = findViewById(R.id.etxtpresentAddress);
        shopCategoryEditText = findViewById(R.id.etxtshopCategory);
        mobilePhoneEditText = findViewById(R.id.etxtmobilePhone);



        loginButton = findViewById(R.id.btnlogin);
        progressBar = findViewById(R.id.progress_bar);

       loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:

                try {


                    JSONObject login = new JSONObject();
                    login.put("name", nameEditText.getText().toString().trim());
                    login.put("proprietorName",proprietorNameEditText.getText().toString().trim());
                    login.put("presentAddress",presentAddressEditText.getText().toString().trim());
                    login.put("shopCategory",shopCategoryEditText.getText().toString().trim());
                    login.put("mobilePhone",mobilePhoneEditText.getText().toString().trim());


                  Intent intent=getIntent();
                    String valuetoken = intent.getStringExtra("token");
                    String token=valuetoken;

                    progressBar.setVisibility(View.VISIBLE);

                     LoginApplication.apiManager.createUser(login,token, new Callback<User>() {


                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        progressBar.setVisibility(View.GONE);
                        User responseUser = response.body();
                        if (response.isSuccessful() && responseUser != null) {
                            Toast.makeText(CreateuserActivity.this,
                                    String.format("Name  %s \n ProprietorName  %s \n PresentAddress %s \n MobilePhone %s\n ShopCategory %s ",
                                            responseUser.getName(),
                                            responseUser.getProprietorName(),
                                            responseUser.getPresentAddress(),
                                            responseUser.getMobilePhone(),
                                            responseUser.getShopCategory()),
                                    Toast.LENGTH_LONG)
                                    .show();


                        } else {
                            Toast.makeText(CreateuserActivity.this,
                                    String.format("Response is %s", String.valueOf(response.code()))
                                    , Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(CreateuserActivity.this,
                                "Error is " + t.getMessage()
                                , Toast.LENGTH_LONG).show();
                    }
                });


                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}