package co.appdev.boilerplate.mvpkotlin.util

import android.content.Context
import android.net.ConnectivityManager
import retrofit2.HttpException

object NetworkUtil {

    fun isHttpStatusCode(throwable: Throwable?, statusCode: Int): Boolean {
        return (throwable is HttpException && throwable.code() == statusCode)
    }

    fun isNetworkConnected(): Boolean {
//        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork = cm.activeNetwork;
//        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        return false;
    }
}