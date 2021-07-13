package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.presentation

import com.appxcore.quicksetup.dagger2.ui.questiondetails.QuestionDetailsActivity
import com.appxcore.quicksetup.dagger2.ui.questionslist.QuestionsListActivity
import com.appxcore.quicksetup.dagger2.ui.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(activity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity)
}