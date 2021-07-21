package com.appxcore.quickSetup.ui.qrScanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appxcore.quickSetup.dagger2.questions.FetchQuestionsUseCase
import com.appxcore.quickSetup.dagger2.questions.Question
import com.appxcore.quickSetup.dagger2.common.baseclasses.ScreensNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs.DialogsNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.fragments.BaseFragment
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.ViewMvcFactory
import kotlinx.coroutines.*
import javax.inject.Inject

class QrScannerFragment : BaseFragment(), QrScannerViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject lateinit var fetchQuestionsUseCase: FetchQuestionsUseCase
    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var viewMvcFactory: ViewMvcFactory

    private lateinit var viewMvc: QrScannerViewMvc

    private var isDataLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewMvc = viewMvcFactory.newQrScannerViewMvc(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            scanNewQrCode()
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    override fun onRefreshClicked() {
        scanNewQrCode()
    }

    override fun onSuccess(result: Object) {
        TODO("Not yet implemented")
    }

    private fun scanNewQrCode() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {

            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }


}