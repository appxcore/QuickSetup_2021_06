package com.appxcore.quickSetup.ui.dashBoardFrame

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc
import com.budiyev.android.codescanner.*
import com.google.zxing.Result

class dashboardNavigatorMvc(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?
): BaseViewMvc<dashboardNavigatorMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.fragment_qr_scanner
) {

    interface Listener {
        fun onRefreshClicked()
        fun onQrCodeReadSuccessfully(result :Object)
        fun qrScannerResult(result: Result)
    }

    private val swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swipeRefresh)



    private val scannerView :CodeScannerView = findViewById(R.id.scanner_view)
    private lateinit var codeScanner: CodeScanner

    init {
        // init pull-down-to-refresh
        swipeRefresh.setOnRefreshListener {
            for (listener in listeners) {
                listener.onRefreshClicked()
            }
        }

    }

    fun scanNewQr(){

        codeScanner = CodeScanner(context, scannerView)

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
              //Toast.makeText(context, "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
            for (listener in listeners) {
                listener.qrScannerResult(it)
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
                Toast.makeText(context, "Camera initialization error: ${it.message}",Toast.LENGTH_LONG).show()

        }

        codeScanner.startPreview()

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