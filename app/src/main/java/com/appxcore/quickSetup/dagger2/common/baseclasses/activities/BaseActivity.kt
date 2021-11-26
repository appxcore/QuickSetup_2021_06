package com.appxcore.quickSetup.dagger2.common.baseclasses.activities

import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.appxcore.quickSetup.dagger2.MyApplication
import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.activity.ActivityModule

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