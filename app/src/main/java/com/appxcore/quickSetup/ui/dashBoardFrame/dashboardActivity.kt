package com.appxcore.quickSetup.ui.dashBoardFrame

import android.os.Bundle
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity

class dashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_content, dashboardNavigationFragment())
                    .commit()
        }

    }


}