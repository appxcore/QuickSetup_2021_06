package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.app

import android.app.Application
import com.appxcore.quicksetup.dagger2.Constants
import com.appxcore.quicksetup.dagger2.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(val application: Application) {

    @Provides
    @AppScope
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    fun application() = application

    @Provides
    @AppScope
    fun stackoverflowApi(retrofit: Retrofit) = retrofit.create(StackoverflowApi::class.java)

}