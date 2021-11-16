package com.appxcore.quickSetup.ui.dashBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc

class DashboardMvc(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?
): BaseViewMvc<DashboardMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.fragment_dashboard
) {

    interface Listener {
        fun onProceedClicked()
        fun scanQr()
    }

    private val btnProceed : Button = findViewById(R.id.btn_dashboard_proceed)
    private val ibScan = findViewById<ImageButton>(R.id.ib_dashboard_scan_qr)

    init {
        btnProceed.setOnClickListener {
            for (listener in listeners) {
                listener.onProceedClicked()
            }
        }

        ibScan.setOnClickListener {
            for (listener in listeners) {
                listener.scanQr()
            }
        }
    }


}