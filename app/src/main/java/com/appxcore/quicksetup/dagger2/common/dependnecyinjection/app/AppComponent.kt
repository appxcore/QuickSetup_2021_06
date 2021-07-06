package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.app

import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity.ActivityComponent
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

}