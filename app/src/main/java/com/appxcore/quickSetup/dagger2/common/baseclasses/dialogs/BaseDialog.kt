package com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs

import android.app.Dialog
import androidx.fragment.app.DialogFragment

open class BaseDialog : DialogFragment(){

    private val presentationComponent by lazy {
        (requireActivity() as com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent

}