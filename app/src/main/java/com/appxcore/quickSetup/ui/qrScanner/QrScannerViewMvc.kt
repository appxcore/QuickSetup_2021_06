package com.appxcore.quickSetup.ui.qrScanner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.questions.Question
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.budiyev.android.codescanner.CodeScanner
import java.util.*

class QrScannerViewMvc(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?
): BaseViewMvc<QrScannerViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.fragment_qr_scanner
) {

    interface Listener {
        fun onRefreshClicked()
        fun onSuccess( result :Object)
    }

    private val swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swipeRefresh)
    private val scannerView :CodeScanner
    private lateinit var codeScanner: CodeScanner

    init {
        // init pull-down-to-refresh
        swipeRefresh.setOnRefreshListener {
            for (listener in listeners) {
                listener.onRefreshClicked()
            }
        }

        scannerView = findViewById(R.id.scanner_view)
        codeScanner = CodeScanner(this, scannerView)

        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                Toast.makeText(this, "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(this, "Camera initialization error: ${it.message}",
                    Toast.LENGTH_LONG).show()
            }
        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

    }

    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        if (swipeRefresh.isRefreshing) {
            swipeRefresh.isRefreshing = false
        }
    }



}