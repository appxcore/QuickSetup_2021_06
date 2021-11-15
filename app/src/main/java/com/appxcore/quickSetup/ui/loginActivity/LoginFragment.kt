package com.appxcore.quickSetup.ui.dashBoardFrame

import android.content.Context
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
import kotlinx.coroutines.*
import javax.inject.Inject

import androidx.fragment.app.FragmentTransaction
import com.appxcore.quickSetup.ui.orderDetails.OrderDetailsFragment


class LoginFragment : BaseFragment() ,
    LoginViewMvc.Listener{

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var viewMvcFactory: ViewMvcFactory

    private lateinit var viewMvc: LoginViewMvc
    private lateinit var onLoginClicked : OnLoginClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnLoginClicked) {
            onLoginClicked = context
        } else {
            throw ClassCastException(requireContext().toString() + " must implement .")
        }
    }


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

    }


    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }


    interface OnLoginClicked{
      fun onSuccessFullLogin()
    }

    override fun onBtnClicked(login: String, password: String, isEmail: Boolean) {
      onLoginClicked.onSuccessFullLogin()
    }



}