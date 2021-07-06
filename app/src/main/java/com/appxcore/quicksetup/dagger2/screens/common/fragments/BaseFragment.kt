package com.appxcore.quicksetup.dagger2.screens.common.fragments

import androidx.fragment.app.Fragment
import com.appxcore.quicksetup.dagger2.screens.common.activities.BaseActivity

open class BaseFragment: Fragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}