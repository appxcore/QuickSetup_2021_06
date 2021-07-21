package com.appxcore.quickSetup.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public final class Preferences {
    private static SharedPreferences sharedPreferences;

    private Preferences(){}

    public static void initPreferences(Activity context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SharedPrefUtils.AppPreference,Context.MODE_PRIVATE);
        }
    }


    public static SharedPreferences getPreferences() {
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getPreferenceEditor(){
        return sharedPreferences.edit();
    }
}
