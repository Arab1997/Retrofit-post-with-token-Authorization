package com.walton.retrofitexample.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.walton.retrofitexample.Activity.CreateuserActivity;

import com.walton.retrofitexample.R;



public class OutletProfileActivity extends AppCompatActivity {

    public Context mContext;
    Button btnOutLetCreateProcessd, btnOutlet;
    TextView tvId, tvCode, tvName, tvProprientorName, tvPresentAddress, tvMobileNumber, tvShopCategory, tvPlazaName, tvAltName, tvVatName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlet_profile);
        mContext = this;

        getWindow().setStatusBarColor( ContextCompat.getColor(mContext , R.color.colorPrimaryDark));

//        getSupportActionBar().setBackgroundDrawable(
//                new ColorDrawable(Color.parseColor("#6b9eef")));
        initialize();
        //toolbar and back button

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



        /*
         * click event out let and order
         *
         * */
        btnOutLetCreateProcessd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proprietorName="";
                Intent intent1 = getIntent();
                if (intent1 != null) {
                    proprietorName = intent1.getStringExtra("proprietorName");
                }
                Intent intent = new Intent(mContext, CreateuserActivity.class);
                intent.putExtra("proprietorName",proprietorName);
                startActivity(intent);
            }
        });
        /*
         * get intent here
         * */
        Intent intent = getIntent();
        if (intent != null) {
            String id = intent.getStringExtra("id");
            tvId.setText(id);
            String code = intent.getStringExtra("code");
            tvCode.setText(code);
            String name = intent.getStringExtra("name");
            tvName.setText(name);
            String presentAddress = intent.getStringExtra("presentAddress");
            tvPresentAddress.setText(presentAddress);
            String proprietorName = intent.getStringExtra("proprietorName");
            tvProprientorName.setText(proprietorName);
            String mobilePhone = intent.getStringExtra("mobilePhone");
            tvMobileNumber.setText(mobilePhone);
            String shopCategory = intent.getStringExtra("shopCategory");
            tvShopCategory.setText(shopCategory);
            String plazaname = intent.getStringExtra("plazaName");
            tvPlazaName.setText(plazaname);
            String altName = intent.getStringExtra("altName");
            tvAltName.setText(altName);
            String vatName = intent.getStringExtra("vatName");
            tvVatName.setText(vatName);
            //toast name when input user 
            // Toast.makeText(mContext,"name :"+stringData, Toast.LENGTH_SHORT).show();
        }
        /// myMarquee = view.findViewById(R.id.myMarquee);

    }

    /*
     * initialize views
     *
     * */
    private void initialize() {
        tvId = findViewById(R.id.tvId);
        tvCode = findViewById(R.id.tvCode);
        tvName = findViewById(R.id.tvName);
        tvProprientorName = findViewById(R.id.tvProprietorName);
        tvPresentAddress = findViewById(R.id.tvPresentAddress);
        tvMobileNumber = findViewById(R.id.tvMobileNumber);
        tvShopCategory = findViewById(R.id.tvShop);
        tvPlazaName = findViewById(R.id.tvPlazaName);
        tvAltName = findViewById(R.id.tvAlet);
        tvVatName = findViewById(R.id.tvVatName);
        btnOutlet = findViewById(R.id.btnoutLetOnlyCreate);
        btnOutLetCreateProcessd = findViewById(R.id.btnOutLetCreateProcess);
    }
}
