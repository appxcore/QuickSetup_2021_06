package com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.appxcore.quickSetup.dagger2.common.baseclasses.imageloader.ImageLoader
import com.appxcore.quickSetup.ui.customerList.CustomerListViewMvc
import com.appxcore.quickSetup.ui.dashBoardFrame.CustomerListFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.DashboardNavigatorMvc
import com.appxcore.quickSetup.ui.dashBoardFrame.OrderHistoryFragment
import com.appxcore.quickSetup.ui.dashBoardStats.DashoardStatsViewMvc
import com.appxcore.quickSetup.ui.loginActivity.LoginViewMvc
import com.appxcore.quickSetup.ui.orderHistory.OrderHistoryViewMvc
import com.appxcore.quickSetup.ui.qrScanner.QrScannerViewMvc
import com.appxcore.quickSetup.ui.questiondetails.QuestionDetailsViewMvc
import com.appxcore.quickSetup.ui.questionslist.QuestionsListViewMvc
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

    fun newDashboardNavigatorViewMvc(parent: ViewGroup?): DashboardNavigatorMvc {
        return DashboardNavigatorMvc(layoutInflater ,parent)
    }

    fun newLoginViewMvc(parent: ViewGroup?): LoginViewMvc {
        return LoginViewMvc(layoutInflater ,parent)
    }

    fun newOrderHistoryMvc(parent: ViewGroup?): OrderHistoryViewMvc {
        return OrderHistoryViewMvc(layoutInflater ,parent)
    }

    fun newCustomerList(parent: ViewGroup?): CustomerListViewMvc {
        return CustomerListViewMvc(layoutInflater ,parent)
    }

    fun newDashBoardStats(parent: ViewGroup?): DashoardStatsViewMvc {
        return DashoardStatsViewMvc(layoutInflater ,parent)
    }
}