package com.appxcore.quickSetup.ui.questionslist

import android.os.Bundle
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.activities.BaseActivity

class QuestionsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_frame)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.frame_content, QuestionsListFragment())
                    .commit()
        }

    }


}