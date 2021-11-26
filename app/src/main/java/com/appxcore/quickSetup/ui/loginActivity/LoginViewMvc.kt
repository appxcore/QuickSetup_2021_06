package com.appxcore.quickSetup.ui.loginActivity

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.appxcore.quickSetup.R
import com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc.BaseViewMvc

class LoginViewMvc(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?
): BaseViewMvc<LoginViewMvc.Listener>(
        layoutInflater,
        parent,
        R.layout.fragment_login
) {

    interface Listener {
        fun onBtnClicked(login: String, password: String, isEmail: Boolean)
    }

    private val etLogin : EditText = findViewById(R.id.et_sign_in_user_name);
    private val etPassword : EditText = findViewById(R.id.et_sign_in_password);
    private val btnLogin : Button = findViewById(R.id.btn_sign_in);

    init {
        btnLogin.setOnClickListener {
            var isEmail = true
            if(etLogin.text.length > 0 ){
                        isEmail = true
                }else{
                        isEmail = false
                }

            for (listener in listeners) {
                listener.onBtnClicked(etLogin.text.toString(),etPassword.text.toString(),isEmail )
            }

        }

    }




}