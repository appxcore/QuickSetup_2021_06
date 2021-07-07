package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.app

import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity.ActivityComponent
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity.ActivityModule
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.services.ServiceComponent
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.services.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

    fun newServiceComponent(servicesModule: ServiceModule): ServiceComponent

}