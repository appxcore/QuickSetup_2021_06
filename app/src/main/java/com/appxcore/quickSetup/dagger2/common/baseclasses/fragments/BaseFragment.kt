package com.appxcore.quickSetup.dagger2.common.baseclasses.fragments

import androidx.fragment.app.Fragment
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity

open class BaseFragment: Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent

    open fun getBackStackName(): String? {
        return javaClass.name
    }
}