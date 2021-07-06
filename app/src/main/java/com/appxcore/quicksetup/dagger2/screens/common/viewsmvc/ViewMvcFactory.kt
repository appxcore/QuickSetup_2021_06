package com.appxcore.quicksetup.dagger2.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.appxcore.quicksetup.dagger2.screens.common.imageloader.ImageLoader
import com.appxcore.quicksetup.dagger2.screens.questiondetails.QuestionDetailsViewMvc
import com.appxcore.quicksetup.dagger2.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
        private val layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, imageLoader, parent)
    }
}