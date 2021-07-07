package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.services

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ServiceModule(
        val service: Service
) {

    @Provides
    fun context(): Context = service

}