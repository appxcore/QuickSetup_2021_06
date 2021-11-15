package com.appxcore.quickSetup.dagger2.common.baseclasses

import androidx.appcompat.app.AppCompatActivity
import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.activity.ActivityScope
import com.appxcore.quickSetup.ui.qrScanner.QrScannerActivity
import com.appxcore.quickSetup.ui.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigator (private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navToCustomerList(){

    }

}