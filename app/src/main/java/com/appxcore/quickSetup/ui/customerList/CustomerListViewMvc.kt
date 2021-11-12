package com.appxcore.quickSetup.ui.customerList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.appxcore.quickSetup.utils.ObjectsGenerics

class CustomerListViewMvc(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?
): BaseViewMvc<CustomerListViewMvc.Listener>(
    layoutInflater,
    parent,
    R.layout.fragment_customer_list
) {
    interface Listener {
        fun onOrderHistoryItemClicked(login: String, password: String, isEmail: Boolean)
    }

    private var listOrderHistory : ArrayList<ObjectsGenerics.ObjOrderHistory> = ArrayList()
    private val rvOrderHistory : RecyclerView = findViewById(R.id.recycler_view)
    private val swipeRefreshLayout : SwipeRefreshLayout = findViewById(R.id.swipeRefresh);
    private var adapterOrderHistory :AdapterCustomerList
    private var  mLayoutManager: GridLayoutManager? = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)

    init {

        var obj : ObjectsGenerics.ObjOrderHistory
        for(i in 1..5){
            obj = ObjectsGenerics.ObjOrderHistory(i.toString(),"10/11/2021","Jake","8582136354","qwe@123.com","120","true")
            listOrderHistory.add(obj)
        }
        rvOrderHistory.layoutManager = mLayoutManager
        adapterOrderHistory = AdapterCustomerList(listOrderHistory, parent!!.context)
        rvOrderHistory.adapter = adapterOrderHistory

    }

}