package com.appxcore.quickSetup.ui.activityBase


import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.imageloader.ImageLoader
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.google.android.material.appbar.AppBarLayout

class BaseHomeViewMvc(
        layoutInflater: LayoutInflater,
        private val imageLoader: ImageLoader,
        parent: ViewGroup?
): BaseViewMvc<BaseHomeViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.activity_home_base
) {

    interface Listener {
        fun onBackClicked()
        fun getToolBarView(toolBar: AppBarLayout)
    }

   private val activity: AppCompatActivity = context as AppCompatActivity
   private var fraManager = activity.supportFragmentManager
   private val toolBar:AppBarLayout = findViewById(R.id.toolbar_dashboard)
   private val fragmentHolder:FrameLayout = findViewById(R.id.frame_dashboard_main_content)
   private val ibMenu:ImageButton = findViewById(R.id.iv_tb_normal_back)


    init {

        for (listener in listeners) {
                listener.getToolBarView(toolBar)
        }


    }

}