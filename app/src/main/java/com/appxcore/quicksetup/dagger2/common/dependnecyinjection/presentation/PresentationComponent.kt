package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.presentation

import com.appxcore.quicksetup.dagger2.screens.questiondetails.QuestionDetailsActivity
import com.appxcore.quicksetup.dagger2.screens.questionslist.QuestionsListActivity
import com.appxcore.quicksetup.dagger2.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent()
interface PresentationComponent {
    fun inject(fragment: QuestionsListFragment)
    fun inject(activity: QuestionDetailsActivity)
    fun inject(questionsListActivity: QuestionsListActivity)
}