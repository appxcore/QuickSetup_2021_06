package com.appxcore.quickSetup.ui.dashBoardFrame

import android.os.Bundle
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity
import com.appxcore.quickSetup.ui.qrScanner.QrScannerFragment

class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_navigation_panel, DashboardNavigationFragment())
                    .commit()


            supportFragmentManager.beginTransaction()
                .add(R.id.frame_dashboard_main_content, QrScannerFragment())
                .commit()
        }

    }


}