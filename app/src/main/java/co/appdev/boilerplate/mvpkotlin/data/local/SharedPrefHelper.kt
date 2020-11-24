package co.appdev.boilerplate.mvpkotlin.data.local

import android.content.SharedPreferences
import co.appdev.boilerplate.mvpkotlin.util.ConstantsUtil
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefHelper @Inject internal constructor(private val preferences: SharedPreferences) : UserDataHelper {

    private fun store(key: ConstantsUtil.PersistenceKey, value: String) {
        preferences.edit().putString(key.toString(), value).apply()
    }

    private fun retrieve(key: ConstantsUtil.PersistenceKey): String? {
        return preferences.getString(key.toString(), "")
    }

    override fun storeIsLogin(isLogin: Boolean) {
        store(ConstantsUtil.PersistenceKey.IS_LOGIN, isLogin.toString())
    }

    override val isLogin: Boolean
        get() = java.lang.Boolean.parseBoolean(retrieve(ConstantsUtil.PersistenceKey.IS_LOGIN))

    override fun clearAllPref() {
        preferences.edit().clear().apply()
    }

    fun storeToken(token: String) {
        store(ConstantsUtil.PersistenceKey.TOKEN, token)
    }

    val token: String? get() = retrieve(ConstantsUtil.PersistenceKey.TOKEN)

}