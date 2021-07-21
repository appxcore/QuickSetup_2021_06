package com.appxcore.quickSetup.dagger2.common.dependnecyinjection.app

import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.activity.ActivityComponent
import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.activity.ActivityModule
import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.service.ServiceComponent
import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.service.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}