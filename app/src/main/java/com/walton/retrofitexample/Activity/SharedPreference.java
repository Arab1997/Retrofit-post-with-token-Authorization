package com.walton.retrofitexample.Activity;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreference {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private static final String PREFS_NAME = "pos";

    public static final String QLIST = "qlist";
    public static final String ACCESS_KEY = "accesskey";



    public SharedPreference() {
        super();
        // TODO Auto-generated constructor stub
    }


    public static boolean getBooleanValue(final Context context, String key) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getBoolean(key, false);
    }


    public static void setBooleanValue(final Context context, String key, Boolean status) {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean(key, status);
        editor.apply();
    }


    public static String getStringValue(final Context context, String key) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getString(key, "value");
    }

    public static void setStringValue(final Context context, String key, String value) {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static int getIntValue(final Context context, String key) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getInt(key, 0);
    }

    public static void setIntValue(final Context context, String key,
                                   int value) {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(key, value);
        editor.apply();
    }

    public static long getLongValue(final Context context, String key) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getLong(key, 0);
    }

    public static void setLongValue(final Context context, String key, long value) {
        final SharedPreferences prefs = context.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void remove(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }


}

