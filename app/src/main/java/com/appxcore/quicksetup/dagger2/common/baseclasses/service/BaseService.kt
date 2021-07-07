package com.appxcore.quicksetup.dagger2.common.baseclasses.service

import android.app.Service
import com.appxcore.quicksetup.dagger2.MyApplication
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.service.ServiceModule

abstract class BaseService : Service(){

    private val appComponent get() = (application as MyApplication).appComponent

    val serviceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }

}