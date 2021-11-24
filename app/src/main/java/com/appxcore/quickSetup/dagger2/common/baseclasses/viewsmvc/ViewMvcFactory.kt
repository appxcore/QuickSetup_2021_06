package com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.appxcore.quickSetup.dagger2.common.baseclasses.imageloader.ImageLoader
import com.appxcore.quickSetup.dagger2.common.baseclasses.popupView.PopUpView
import com.appxcore.quickSetup.ui.activityBase.BaseHomeViewMvc
import com.appxcore.quickSetup.ui.dashBoard.DashboardMvc
import com.appxcore.quickSetup.ui.customerList.CustomerListViewMvc
import com.appxcore.quickSetup.ui.dashBoardFrame.DashboardNavigatorMvc
import com.appxcore.quickSetup.ui.orderDetails.OrderDetailsViewMvc
import com.appxcore.quickSetup.ui.loginActivity.LoginViewMvc
import com.appxcore.quickSetup.ui.orderHistory.OrderHistoryViewMvc
import com.appxcore.quickSetup.ui.qrScanner.QrScannerViewMvc
import com.appxcore.quickSetup.ui.questiondetails.QuestionDetailsViewMvc
import com.appxcore.quickSetup.ui.questionslist.QuestionsListViewMvc
import javax.inject.Inject

class ViewMvcFactory @Inject constructor(
        private val layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader,
        private val popUpView: PopUpView
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflater, parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvc(layoutInflater, imageLoader, parent)
    }

    fun newBaseHomeViewMvc(parent: ViewGroup?): BaseHomeViewMvc {
        return BaseHomeViewMvc(layoutInflater, imageLoader, popUpView, parent)
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

    fun newOrderDetails(parent: ViewGroup?): OrderDetailsViewMvc {
        return OrderDetailsViewMvc(layoutInflater ,parent)
    }

    fun newDashBoard(parent: ViewGroup?): DashboardMvc {
        return DashboardMvc(layoutInflater ,parent)
    }
}