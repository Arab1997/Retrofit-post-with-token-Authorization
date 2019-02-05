package com.walton.retrofitexample.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;


public class AppsSettings {
    private static AppsSettings appsSettings = null;
    private Context mContext;
    private SharedPreferences sharedPreferences;

    private AppsSettings(Context context) {
        mContext = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public static AppsSettings getAppsSettings(Context mContext) {
        if (appsSettings == null) {
            appsSettings = new AppsSettings(mContext);
        }
        return appsSettings;
    }

    public void setAccessKey(String mValue) {
        Editor editor = sharedPreferences.edit();
        editor.putString( AppConstants.ACCESSKEY, mValue);
        editor.commit();
    }

    public String getAccessKey() {
        return sharedPreferences.getString(AppConstants.ACCESSKEY, "");
    }



    public void setName(String mValue) {
        Editor editor = sharedPreferences.edit();
        editor.putString(AppConstants.NAME, mValue);
        editor.commit();
    }

    public String getName() {
        return sharedPreferences.getString(AppConstants.NAME, "");
    }
    public void setAddress(String mValue) {
        Editor editor = sharedPreferences.edit();
        editor.putString(AppConstants.ADDRESS, mValue);
        editor.commit();
    }

    public String getAddress() {
        return sharedPreferences.getString(AppConstants.ADDRESS, "");
    }
    public void setContact(String mValue) {
        Editor editor = sharedPreferences.edit();
        editor.putString(AppConstants.CONTACT, mValue);
        editor.commit();
    }

    public String getContact() {
        return sharedPreferences.getString(AppConstants.CONTACT, "");
    }

}
