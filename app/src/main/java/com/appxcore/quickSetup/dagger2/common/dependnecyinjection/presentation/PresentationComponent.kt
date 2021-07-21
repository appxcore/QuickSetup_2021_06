package com.appxcore.quickSetup.dagger2.common.dependnecyinjection.presentation

import com.appxcore.quickSetup.ui.qrScanner.QrScannerFragment
import com.appxcore.quickSetup.ui.questiondetails.QuestionDetailsActivity
import com.appxcore.quickSetup.ui.questionslist.QuestionsListActivity
import com.appxcore.quickSetup.ui.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(activity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity)
    fun inject(qrScannerFragment: QrScannerFragment)
}