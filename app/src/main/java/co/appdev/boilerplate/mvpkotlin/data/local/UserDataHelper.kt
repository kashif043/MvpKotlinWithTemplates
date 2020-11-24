package co.appdev.boilerplate.mvpkotlin.data.local

interface UserDataHelper {

    fun storeIsLogin(isLogin: Boolean)

    val isLogin: Boolean

    fun clearAllPref()
}