package com.appxcore.quickSetup.ui.dashBoard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appxcore.quickSetup.dagger2.common.baseclasses.ScreensNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs.DialogsNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.fragments.BaseFragment
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.ViewMvcFactory
import kotlinx.coroutines.*
import javax.inject.Inject

class DashboardFragment : BaseFragment(),
    DashboardMvc.Listener{

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var viewMvcFactory: ViewMvcFactory
    private lateinit var viewMvc: DashboardMvc
    private lateinit var interfaceQrScanner : InterfaceQrScanner

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DashboardFragment.InterfaceQrScanner) {
            interfaceQrScanner = context
        } else {
            throw ClassCastException(requireContext().toString() + " must implement .")
        }
    }

    interface InterfaceQrScanner{
        fun onScanQrRequest()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewMvc = viewMvcFactory.newDashBoard(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    override fun onProceedClicked() {

    }

    override fun scanQr() {
       interfaceQrScanner.onScanQrRequest()
    }



}