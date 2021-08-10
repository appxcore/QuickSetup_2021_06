package com.appxcore.quickSetup.ui.dashBoardFrame

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.ScreensNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.dialogs.DialogsNavigator
import com.appxcore.quickSetup.dagger2.common.baseclasses.fragments.BaseFragment
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.ViewMvcFactory
import com.appxcore.quickSetup.dagger2.questions.FetchQuestionsUseCase
import com.google.zxing.Result
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.annotations.AfterPermissionGranted
import kotlinx.coroutines.*
import javax.inject.Inject

class dashboardNavigationFragment : BaseFragment(){

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator
    @Inject lateinit var viewMvcFactory: ViewMvcFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewMvc = viewMvcFactory.newQrScannerViewMvc(container)
        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        /*if (!isDataLoaded) {
            scanNewQrCode()
        }*/
    }

    override fun onResume() {
        super.onResume()
        onClickRequestPermissionCamera()
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    override fun onRefreshClicked() {
        scanNewQrCode()
    }

    override fun onQrCodeReadSuccessfully(result: Object) {
        TODO("Not yet implemented")
    }

    override fun qrScannerResult(result: Result) {
        Handler(Looper.getMainLooper()).post{
            Toast.makeText(requireContext(), result.text,Toast.LENGTH_LONG).show()
        }

    }

    private fun scanNewQrCode() {

     /*   viewMvc.scanNewQr()

        return*/

        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                viewMvc.scanNewQr()
            } finally {
                viewMvc.hideProgressIndication()
            }
        }
    }


    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        Handler(Looper.getMainLooper()).post{
            Toast.makeText(requireContext(), "This permission is a must to use this application",Toast.LENGTH_LONG).show()
            onClickRequestPermissionCamera()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        scanNewQrCode()
    }

    override fun onRationaleAccepted(requestCode: Int) {
      //  TODO("Not yet implemented")
    }

    override fun onRationaleDenied(requestCode: Int) {
     //   TODO("Not yet implemented")
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    private fun onClickRequestPermissionCamera() {
        if (EasyPermissions.hasPermissions(context, Manifest.permission.CAMERA)) {
           scanNewQrCode()
        } else {
            // Request one permission
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.rationale_camera),
                RC_CAMERA_PERM,
                Manifest.permission.CAMERA
            )
        }
    }

    companion object {
        private const val RC_CAMERA_PERM = 123
        private const val RC_CONTACTS_PERM = 124
    }


}