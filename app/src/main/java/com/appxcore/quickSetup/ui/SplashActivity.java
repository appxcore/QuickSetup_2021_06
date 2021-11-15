package com.appxcore.quickSetup.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity;
import com.appxcore.quickSetup.ui.activityBase.BaseHomeActivity;
import com.appxcore.quickSetup.ui.dashBoardFrame.LoginActivity;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 500;  // mSeconds
    Intent i;
    Boolean isLoggedInUser;

    @Inject


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isLoggedInUser = false;

        if(!isLoggedInUser){

            i = new Intent(this, BaseHomeActivity.class);

        }else {

            i = new Intent(this, BaseHomeActivity.class);

        }


        Intent2Activity();


    }


    private void Intent2Activity() {



        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}