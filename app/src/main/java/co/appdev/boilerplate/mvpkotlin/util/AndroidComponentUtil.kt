package co.appdev.boilerplate.mvpkotlin.util

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager

object AndroidComponentUtil {
    fun toggleComponent(
        context: Context,
        componentClass: Class<*>?,
        enable: Boolean
    ) {
        val componentName = ComponentName(context, componentClass!!)
        val pm = context.packageManager
        pm.setComponentEnabledSetting(
            componentName,
            if (enable) PackageManager.COMPONENT_ENABLED_STATE_ENABLED else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}