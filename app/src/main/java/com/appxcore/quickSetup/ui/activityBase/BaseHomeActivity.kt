package com.appxcore.quickSetup.ui.activityBase

import android.opengl.Visibility
import android.os.Bundle
import android.widget.ImageButton
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity
import com.appxcore.quickSetup.R.*
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.ui.dashBoardFrame.CustomerListFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.LoginFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.OrderHistoryFragment
import com.appxcore.quickSetup.ui.dashBoardStats.DashBoardStatsFragment
import com.google.android.material.appbar.AppBarLayout


class BaseHomeActivity : BaseActivity(){

    lateinit var toolBar: AppBarLayout
    lateinit var fragmentHolder : FrameLayout
    lateinit var ibMenu : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home_base)

        toolBar = findViewById(id.toolbar_dashboard)
        fragmentHolder = findViewById(id.frame_dashboard_main_content)
        ibMenu = findViewById(id.iv_tb_normal_back)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
            .add(id.frame_dashboard_main_content, LoginFragment())
            .commit()
          //  toolBar.visibility = View.GONE
        }


        ibMenu.setOnClickListener {
           showListMenu(ibMenu,fragmentHolder)
            toolBar.visibility = View.VISIBLE
        }

    }

    private fun showListMenu(menuAnchor: View, fragmentHolder: FrameLayout) {

       val popUpView: View = layoutInflater.inflate(layout.fragment_navigation, null) // inflating popup layout
       val mPopUp = PopupWindow(
            popUpView, WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT, true
        ) // Creation of popup
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

        val dashBoardStatsFragment = DashBoardStatsFragment()
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentHolder.id,dashBoardStatsFragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

    private fun navToOrderHistory(fragmentHolder: FrameLayout) {

        val orderHistoryFrag = OrderHistoryFragment()
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentHolder.id,orderHistoryFrag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

    private fun navToCustomerList(fragmentHolder: FrameLayout) {

        val customerListFragment = CustomerListFragment()
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentHolder.id,customerListFragment)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }


}