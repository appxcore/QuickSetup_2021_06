package com.appxcore.quickSetup.ui.orderHistory

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.appxcore.quickSetup.ui.loginActivity.LoginViewMvc
import com.appxcore.quickSetup.utils.ObjectsGenerics

class OrderHistoryViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
): BaseViewMvc<OrderHistoryViewMvc.Listener>(
    layoutInflater,
    parent,
    R.layout.fragment_order_history
) {
    interface Listener {
        fun onOrderHistoryItemClicked(login: String, password: String, isEmail: Boolean)
    }

    private var listOrderHistory : ArrayList<ObjectsGenerics.ObjOrderHistory> = ArrayList()

    private val rvOrderHistory : RecyclerView = findViewById(R.id.recycler_order_history)
    private val swipeRefreshLayout : SwipeRefreshLayout = findViewById(R.id.swipeRefresh_order_history);
    private lateinit var adapterOrderHistory :AdapterOrderHistory
    private var  mLayoutManager: GridLayoutManager? = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)

    init {
        var obj : ObjectsGenerics.ObjOrderHistory

        for(i in 1..5){
            obj = ObjectsGenerics.ObjOrderHistory(i.toString(),"10/11/2021","Jake","8582136354","qwe@123.com","120","true")
            listOrderHistory.add(obj)
        }
        rvOrderHistory.layoutManager = mLayoutManager
        adapterOrderHistory = AdapterOrderHistory(listOrderHistory)
        rvOrderHistory.adapter = adapterOrderHistory

        showToast(listOrderHistory.size.toString())
    }



}