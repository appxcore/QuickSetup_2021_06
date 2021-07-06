package com.appxcore.quicksetup.dagger2.screens.common.activities


import androidx.appcompat.app.AppCompatActivity
import com.appxcore.quicksetup.dagger2.MyApplication
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity.ActivityModule

open class BaseActivity: AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}