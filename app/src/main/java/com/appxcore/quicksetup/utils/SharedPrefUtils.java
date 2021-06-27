package com.appxcore.quicksetup.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {


    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(AppPreference, Context.MODE_PRIVATE);
    }

    public static void setAccessToken(Context context, String apiKey) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(accessToken, apiKey);
        editor.apply();
    }

    public static String getAccessToken(Context context) {
        return getSharedPreferences(context).getString(accessToken, "");
    }


    public static void setAuthToken(Context context, String apiKey) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(authToken, apiKey);
        editor.apply();
    }

    public static String getAuthToken(Context context) {
        String authtoken ="";
        if(getSharedPreferences(context)!=null){
            authtoken = getSharedPreferences(context).getString(authToken, "");
            if(authtoken!=null){
                if(!authtoken.equals("")){
                    return authtoken;
                }else{
                    return "";
                }
            }else{
                return "";
            }
        }
        return authtoken;
    }


    public static void setEmailId(Context context, String emailid) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(emailId, emailid);
        editor.apply();
    }


    public static String getEmailId(Context context) {
        return getSharedPreferences(context).getString(emailId, "");
    }

    public static void setGid(Context context, String gid) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(Gid, gid);
        editor.apply();
    }

    public static void setAutologin(Context context, Boolean autologin) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(OtpVerify, autologin);
        editor.apply();
    }
    public static boolean getAutologin(Context context) {
        return getSharedPreferences(context).getBoolean(OtpVerify,false);
    }


    public static void setGuestuser(Context context, Boolean guestuser) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(GuestUser, guestuser);
        editor.apply();
    }
    public static boolean getGuestuser(Context context) {
        return getSharedPreferences(context).getBoolean(GuestUser,false);
    }
    public static String getGid(Context context) {
        return getSharedPreferences(context).getString(Gid, "");
    }


    public static String AppPreference = "AppPreference";
    public static String OtpVerify = "OtpVerify";
    public static String FIRST_INIT = "FIRST_INIT";
    public static String GuestUser = "GuestUser";

    public static String accessToken = "accessToken";
    public static String authToken = "authToken";
    public static String emailId = "emailid";
    public static String guid = "guid";

    public static String Gid = "gid";


    public static String getApiKey(Context context) {
        return "";
    }
}
