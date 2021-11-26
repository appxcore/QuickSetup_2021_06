package com.appxcore.quickSetup.ui.activityBase


import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.appxcore.quickSetup.dagger2.Constants
import com.appxcore.quickSetup.dagger2.common.baseclasses.imageloader.ImageLoader
import com.appxcore.quickSetup.dagger2.common.baseclasses.popupView.PopUpView
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.appxcore.quickSetup.ui.dashBoard.DashboardFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.CustomerListFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.LoginFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.OrderHistoryFragment
import com.appxcore.quickSetup.ui.orderDetails.OrderDetailsFragment
import com.appxcore.quickSetup.ui.qrScanner.QrScannerFragment
import com.google.android.material.appbar.AppBarLayout
import androidx.fragment.app.FragmentManager
import com.appxcore.quickSetup.R

import com.appxcore.quickSetup.dagger2.common.baseclasses.fragments.BaseFragment




class BaseHomeViewMvc(
    layoutInflater: LayoutInflater,
    imageLoader: ImageLoader,
    popUpView: PopUpView,
    parent: ViewGroup?
): BaseViewMvc<BaseHomeViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.activity_home_base
) {

    interface Listener {
        fun onBackClicked()
        fun getToolBarView(toolBar: AppBarLayout)
    }

   private val activity: AppCompatActivity = context as AppCompatActivity
   private var fraManager = activity.supportFragmentManager
   private val toolBar:AppBarLayout = findViewById(R.id.toolbar_dashboard)
   private val fragmentHolder:FrameLayout = findViewById(R.id.frame_dashboard_main_content)
   private val ibMenu:ImageButton = findViewById(R.id.iv_tb_normal_back)
   private var fragmentTransaction : FragmentTransaction


    init {

        fragmentTransaction = activity.supportFragmentManager.beginTransaction()

        for (listener in listeners) {
                listener.getToolBarView(toolBar)
        }

        fraManager.addFragmentOnAttachListener { _, fragment ->
            if(fragment is LoginFragment ){
                toolBar.visibility = View.GONE
            }else{
                toolBar.visibility = View.VISIBLE
            }
        }

        ibMenu.setOnClickListener {
            showListMenu(ibMenu ,popUpView)
        }

    }

    fun navigateToLogin() {
        fraManager.beginTransaction()
            .add(R.id.frame_dashboard_main_content, LoginFragment(), Constants.FRAGMENT_LOGIN)
            .commit()
    }

    private fun mtdFragmentTransaction(fragmentToLoad: BaseFragment, fragmentHolder: FrameLayout) {

        val fragment: Fragment? = fraManager.findFragmentByTag(Constants.FRAGMENT_LOGIN)
        if (fragment != null) fraManager.beginTransaction().remove(fragment).commit()

       /* fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentHolder.id, fragmentToLoad)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()*/

        setPrimaryContentFragment(fragmentToLoad, false)
    }

    private fun navToOrderDetails() {
        mtdFragmentTransaction(OrderDetailsFragment(), fragmentHolder)
    }

    private fun navToOrderHistory() {
        mtdFragmentTransaction(OrderHistoryFragment(), fragmentHolder)
    }

    private fun navToCustomerList() {
        mtdFragmentTransaction(CustomerListFragment(), fragmentHolder)
    }

    private fun navToDashboard() {
        mtdFragmentTransaction(DashboardFragment(), fragmentHolder)
    }

    fun navToQrScanner() {
        mtdFragmentTransaction(QrScannerFragment(), fragmentHolder)
    }


    fun onSuccessFullLogin() {
        toolBar.visibility = View.VISIBLE
        navToDashboard()
    }


    private fun showListMenu(menuAnchor: View, popUpView: PopUpView) {

        val tvMenu1 = popUpView.getPopupView().findViewById<TextView>(R.id.text_nav_01)
        tvMenu1.setOnClickListener {
            popUpView.dismissPopup()
            setPrimaryContentFragment(OrderDetailsFragment(),true)
        }

        val tvMenu2 = popUpView.getPopupView().findViewById<TextView>(R.id.text_nav_02)
        tvMenu2.setOnClickListener {
            popUpView.dismissPopup()
            setPrimaryContentFragment(CustomerListFragment(),true)
        }

        val tvMenu3 = popUpView.getPopupView().findViewById<TextView>(R.id.text_nav_03)
        tvMenu3.setOnClickListener {
            popUpView.dismissPopup()
            setPrimaryContentFragment(OrderHistoryFragment(),true)
        }

        popUpView.showPopWindow(menuAnchor)
    }

    private fun setPrimaryContentFragment(fragment: BaseFragment, allowStack: Boolean) {
         val backStackName: String? = fragment.getBackStackName()

        val fragmentPopped: Boolean = fraManager.popBackStackImmediate(backStackName, 0)
        if (!fragmentPopped) { //fragment not in back stack, create it.
            if (!allowStack && fraManager.backStackEntryCount > 1) {
                fraManager.popBackStack(fraManager.getBackStackEntryAt(0).id, 0)
            }
            val transaction: FragmentTransaction = fraManager.beginTransaction()
            transaction.replace(fragmentHolder.id, fragment)
            transaction.addToBackStack(backStackName)
            transaction.commit()
            try {
                fraManager.executePendingTransactions()
            } catch (exception: IllegalStateException) {
                // Move along as this will be resolved async
            }
        }
    }

    fun getCurrentFragment(): Fragment? {
       return fraManager.findFragmentById(fragmentHolder.id)
    }

    fun popBackStack() {
        fraManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }


}