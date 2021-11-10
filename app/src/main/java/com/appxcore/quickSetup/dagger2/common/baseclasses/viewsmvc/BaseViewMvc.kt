package com.appxcore.quickSetup.dagger2.common.baseclasses.viewsmvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes

open class BaseViewMvc<LISTENER_TYPE>(
        private val layoutInflater: LayoutInflater,
        private val parent: ViewGroup?,
        @LayoutRes private val layoutId: Int
) {

    val rootView: View = layoutInflater.inflate(layoutId, parent, false)

    protected val context: Context get() = rootView.context

    protected val listeners = HashSet<LISTENER_TYPE>()


    fun registerListener(listener: LISTENER_TYPE) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_TYPE) {
        listeners.remove(listener)
    }

    protected fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

    fun showToast(message: String?) {
        if (message != null) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        } else {
            //Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }


}