package com.appxcore.quickSetup.dagger2.common.baseclasses.popupView

import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.appxcore.quickSetup.R
import javax.inject.Inject

class PopUpView @Inject constructor(private val activity: AppCompatActivity) {

    private val popUpView: View = activity.layoutInflater.inflate(R.layout.fragment_navigation, null) // inflating popup layout
    private val mPopUp = PopupWindow(
        popUpView, WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.WRAP_CONTENT, true
    )
    fun getPopupView(): View {
        return popUpView
    }

    fun showPopWindow(menuAnchor : View){
        mPopUp.animationStyle = android.R.style.Animation_Dialog
        mPopUp.showAsDropDown(menuAnchor)
    }

    fun dismissPopup(){
        mPopUp.dismiss()
    }

}