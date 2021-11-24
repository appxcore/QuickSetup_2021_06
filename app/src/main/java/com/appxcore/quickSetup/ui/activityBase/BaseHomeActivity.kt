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

    override fun onBackClicked() {

       /* if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tap Back again to exit.", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }*/

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

    private val timeInterval = 1500
    private var mBackPressed: Long = 0

    override fun onBackPressed() {

        if (mBackPressed + timeInterval >System.currentTimeMillis()){

                super.onBackPressed()
                return

        }else{
           viewMvc.showToast("Tap Back again to exit.")
        }

        mBackPressed = System.currentTimeMillis()
    }

}