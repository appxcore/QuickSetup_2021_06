package com.appxcore.quickSetup.ui.dashBoardStats

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.appxcore.quickSetup.ui.customerList.AdapterCustomerList
import com.appxcore.quickSetup.utils.ObjectsGenerics

class DashoardStatsViewMvc(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?
): BaseViewMvc<DashoardStatsViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.fragment_dashboard_stats
) {

    interface Listener {
        fun onBtnClicked()
    }

    private var listOrderHistory : ArrayList<ObjectsGenerics.ObjOrderHistory> = ArrayList()
    private val rvOrderHistory : RecyclerView = findViewById(R.id.recycler)
    private var adapterOrderHistory :AdapterOrderDetails
    private var  mLayoutManager: GridLayoutManager? = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)

    init {

        var obj : ObjectsGenerics.ObjOrderHistory
        for(i in 1..5){
            obj = ObjectsGenerics.ObjOrderHistory(i.toString(),"10/11/2021","Jake","8582136354","qwe@123.com","120","true")
            listOrderHistory.add(obj)
        }
        rvOrderHistory.layoutManager = mLayoutManager
        adapterOrderHistory = AdapterOrderDetails(listOrderHistory, parent!!.context)
        rvOrderHistory.adapter = adapterOrderHistory

    }



}