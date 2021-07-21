package com.appxcore.quickSetup.networking.service;

import android.content.Context;

import com.appxcore.quickSetup.BuildConfig;


/**
 * Created by kural on 10/10/17.
 */

public class ApiUtils {


        private ApiUtils() {}

        private static final String BASE_URL = BuildConfig.APPLICATION_ID;

        public static ApiInterface getAPIService() {

            return RetroFitClient.getClient(BASE_URL).create(ApiInterface.class);
        }

        public static ApiInterface getAPIServiceRx(Context context) {

            return RetroFitBuilderReactive.getRxClient(BASE_URL,context)
                    .create(ApiInterface.class);
        }

    public static ApiInterface getAPIServiceRxBaseUrl(Context context, String baseUrl) {

        return RetroFitBuilderReactive.getRxClient(baseUrl,context)
                .create(ApiInterface.class);
    }

}
