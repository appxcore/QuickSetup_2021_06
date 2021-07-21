package com.appxcore.quickSetup.dagger2.common.dependnecyinjection.service

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