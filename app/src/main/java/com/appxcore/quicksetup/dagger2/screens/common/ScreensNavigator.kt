package com.appxcore.quicksetup.dagger2.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity.ActivityScope
import com.appxcore.quicksetup.dagger2.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigator (private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }
}