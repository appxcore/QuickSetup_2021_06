package com.appxcore.quickSetup.ui.dashBoardFrame

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appxcore.quickSetup.dagger2.common.baseclasses.ScreensNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs.DialogsNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.fragments.BaseFragment
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.ViewMvcFactory
import com.appxcore.quickSetup.ui.loginActivity.LoginViewMvc
import com.appxcore.quickSetup.ui.orderHistory.ActivityOrderHistory
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginFragment : BaseFragment(),
    LoginViewMvc.Listener{

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var viewMvcFactory: ViewMvcFactory

    private lateinit var viewMvc: LoginViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewMvc = viewMvcFactory.newLoginViewMvc(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        /*if (!isDataLoaded) {
            scanNewQrCode()
        }*/
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    override fun onNavItemClicked(i: Int) {
        Toast.makeText(context,""+i,Toast.LENGTH_LONG).show()
    }

    override fun onBtnClicked(login: String, password: String, isEmail: Boolean) {
        val orderHis = Intent(activity, ActivityOrderHistory::class.java)
        startActivity(orderHis)
    }


}