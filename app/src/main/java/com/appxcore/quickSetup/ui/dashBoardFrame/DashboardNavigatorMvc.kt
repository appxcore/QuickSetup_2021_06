package com.appxcore.quickSetup.ui.dashBoardFrame

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc

class DashboardNavigatorMvc(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?
): BaseViewMvc<DashboardNavigatorMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.fragment_navigation
) {

    interface Listener {
        fun onNavItemClicked(i: Int)
    }

    private val tvN1 : TextView = findViewById(R.id.text_nav_01)

    init {
        tvN1.setOnClickListener {
            for (listener in listeners) {
                listener.onNavItemClicked(1)
            }
        }
    }

    fun onClickNavItem1(){

    }





}