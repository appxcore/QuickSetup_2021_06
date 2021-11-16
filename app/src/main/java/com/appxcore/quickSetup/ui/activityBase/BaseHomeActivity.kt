package com.appxcore.quickSetup.ui.activityBase

import android.os.Bundle
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity
import com.appxcore.quickSetup.R.*
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.Constants
import com.appxcore.quickSetup.dagger2.common.baseclasses.ScreensNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs.DialogsNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.ViewMvcFactory
import com.appxcore.quickSetup.ui.dashBoard.DashboardFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.CustomerListFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.LoginFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.OrderHistoryFragment
import com.appxcore.quickSetup.ui.orderDetails.OrderDetailsFragment
import com.appxcore.quickSetup.ui.qrScanner.QrScannerFragment
import com.google.android.material.appbar.AppBarLayout
import javax.inject.Inject


class BaseHomeActivity : BaseActivity(),
    BaseHomeViewMvc.Listener,
    LoginFragment.OnLoginClicked,
    DashboardFragment.InterfaceQrScanner{

    lateinit var toolBar: AppBarLayout
    lateinit var fragmentHolder : FrameLayout
    lateinit var ibMenu : ImageButton
    var fraManager = supportFragmentManager
    lateinit var fragmentTransaction : FragmentTransaction

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator
    @Inject
    lateinit var screensNavigator: ScreensNavigator
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    private lateinit var viewMvc: BaseHomeViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        viewMvc = viewMvcFactory.newBaseHomeViewMvc(null)
        setContentView(viewMvc.rootView)

        fragmentHolder = findViewById(id.frame_dashboard_main_content)
        ibMenu = findViewById(id.iv_tb_normal_back)

        fragmentTransaction = supportFragmentManager.beginTransaction()

        if (savedInstanceState == null) {

            fraManager.beginTransaction()
            .add(id.frame_dashboard_main_content, LoginFragment(), Constants.FRAGMENT_LOGIN)
            .commit()
        }

        fraManager.addFragmentOnAttachListener { fragmentManager, fragment ->
            if(fragment is LoginFragment ){
                toolBar.visibility = View.GONE
            }else{
                toolBar.visibility = View.VISIBLE
            }
        }

        ibMenu.setOnClickListener {
           showListMenu(ibMenu,fragmentHolder)
            toolBar.visibility = View.VISIBLE
        }

    }

    private fun mtdFragmentTransaction(fragmentToLoad: Fragment, fragmentHolder: FrameLayout) {
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentHolder.id, fragmentToLoad)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun showListMenu(menuAnchor: View, fragmentHolder: FrameLayout) {

       val popUpView: View = layoutInflater.inflate(layout.fragment_navigation, null) // inflating popup layout
       val mPopUp = PopupWindow(
            popUpView, WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT, true
        )
        mPopUp.animationStyle = android.R.style.Animation_Dialog
        mPopUp.showAsDropDown(menuAnchor)

        val tvMenu1 = popUpView.findViewById<TextView>(R.id.text_nav_01)
        tvMenu1.setOnClickListener {
            mPopUp.dismiss()
            navToOrderDetails(fragmentHolder)
        }

        val tvMenu2 = popUpView.findViewById<TextView>(R.id.text_nav_02)
        tvMenu2.setOnClickListener {
            mPopUp.dismiss()
            navToCustomerList(fragmentHolder)
        }

        val tvMenu3 = popUpView.findViewById<TextView>(R.id.text_nav_03)
        tvMenu3.setOnClickListener {
            mPopUp.dismiss()
            navToOrderHistory(fragmentHolder)
        }

    }


    private fun navToOrderDetails(fragmentHolder: FrameLayout) {
        mtdFragmentTransaction(OrderDetailsFragment(), fragmentHolder)
    }

    private fun navToOrderHistory(fragmentHolder: FrameLayout) {
        mtdFragmentTransaction(OrderHistoryFragment(), fragmentHolder)
    }

    private fun navToCustomerList(fragmentHolder: FrameLayout) {
        mtdFragmentTransaction(CustomerListFragment(), fragmentHolder)
     }

    private fun navToDashboard(fragmentHolder: FrameLayout) {
        mtdFragmentTransaction(DashboardFragment(), fragmentHolder)
    }

    private fun navToQrScanner(fragmentHolder: FrameLayout) {
        mtdFragmentTransaction(QrScannerFragment(), fragmentHolder)
    }


    override fun onSuccessFullLogin() {
       toolBar.visibility = View.VISIBLE
       navToDashboard(fragmentHolder)
    }

    override fun onScanQrRequest() {
       navToQrScanner(fragmentHolder)
    }

    override fun onBackClicked() {

    }

    override fun getToolBarView(toolBar: AppBarLayout) {
        this.toolBar = toolBar
    }


}