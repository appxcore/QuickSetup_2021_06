package com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.appxcore.quickSetup.dagger2.common.baseclasses.imageloader.ImageLoader
import com.appxcore.quickSetup.ui.qrScanner.QrScannerViewMvc
import com.appxcore.quickSetup.ui.questiondetails.QuestionDetailsViewMvc
import com.appxcore.quickSetup.ui.questionslist.QuestionsListViewMvc
import com.budiyev.android.codescanner.CodeScanner
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

    fun newQrScannerViewMvc(parent: ViewGroup?): QrScannerViewMvc {
        return QrScannerViewMvc(layoutInflater ,parent)
    }
}