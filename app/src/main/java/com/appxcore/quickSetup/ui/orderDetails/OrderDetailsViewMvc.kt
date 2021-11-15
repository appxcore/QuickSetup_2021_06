package com.appxcore.quickSetup.ui.orderDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.appxcore.quickSetup.utils.ObjectsGenerics

class OrderDetailsViewMvc(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?
): BaseViewMvc<OrderDetailsViewMvc.Listener>(
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