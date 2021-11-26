package com.appxcore.quickSetup.ui.activityBase

import android.os.Bundle
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity
import com.appxcore.quickSetup.dagger2.common.baseclasses.ScreensNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs.DialogsNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.ViewMvcFactory
import com.appxcore.quickSetup.ui.dashBoard.DashboardFragment
import com.appxcore.quickSetup.ui.dashBoardFrame.LoginFragment
import com.google.android.material.appbar.AppBarLayout
import javax.inject.Inject
import android.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.fragments.BaseFragment


class BaseHomeActivity : BaseActivity(),
    BaseHomeViewMvc.Listener,
    LoginFragment.OnLoginClicked,
    DashboardFragment.InterfaceQrScanner{

    lateinit var toolBar: AppBarLayout

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator
    @Inject
    lateinit var screensNavigator: ScreensNavigator
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    private lateinit var viewMvc: BaseHomeViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        viewMvc = viewMvcFactory.newBaseHomeViewMvc(null)
        setContentView(viewMvc.rootView)

        if (savedInstanceState == null) {
            viewMvc.navigateToLogin()
        }

    }

    private val timeInterval = 1500
    private var mBackPressed: Long = 0

    override fun onBackClicked() {


      /*  val f: BaseFragment = getActivity().getFragmentManager().findFragmentById(R.id.fragment_container)
        if (f is CustomFragmentClass) // do something with f
            (f as CustomFragmentClass).doSomething()*/


    }

    override fun getToolBarView(toolBar: AppBarLayout) {
        this.toolBar = toolBar
    }

    override fun onScanQrRequest() {
        viewMvc.navToQrScanner()
    }

    override fun onSuccessFullLogin() {
        viewMvc.onSuccessFullLogin()
    }

    override fun onBackPressed() {

        if (viewMvc.getCurrentFragment() is DashboardFragment){

            if (mBackPressed + timeInterval >System.currentTimeMillis()){

                super.onBackPressed()
                finish()
                return

            }else{
                viewMvc.showToast("Tap Back again to exit.")
            }
            mBackPressed = System.currentTimeMillis()
        }else{
           // viewMvc.popBackStack()
            super.onBackPressed()
        }
    }

}