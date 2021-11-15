package com.appxcore.quickSetup.dagger2.common.dependnecyinjection.presentation

import com.appxcore.quickSetup.ui.dashBoardFrame.CustomerListFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.DashboardNavigationFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.LoginFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.OrderHistoryFragment
import com.appxcore.quickSetup.ui.orderDetails.OrderDetailsFragment
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
    fun inject(dashboardNavigationFragment: DashboardNavigationFragment)
    fun inject(loginFragment: LoginFragment)
    fun inject(orderHistoryFragment: OrderHistoryFragment)
    fun inject(customerListFragment: CustomerListFragment)
    fun inject(orderDetailsFragment: OrderDetailsFragment)
}