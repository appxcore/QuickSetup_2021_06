package com.appxcore.quicksetup.dagger2

import android.app.Application
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.app.AppModule
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.app.DaggerAppComponent

class MyApplication: Application() {

    public val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

}