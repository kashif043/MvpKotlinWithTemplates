package co.appdev.boilerplate.mvpkotlin.util

object ConstantsUtil {
    const val SPLASH_TIME_OUT = 3 // Seconds
    const val SHARED_PREFERENCES_NAME = "generalprefs"
    const val THREAD_NAME = "SyncServiceThread"
    const val START = "start"
    const val STOP = "stop"
    const val WAKE_LOCK_TAG = "PartialWakeLockCPU"
    const val WAKE_LOCK_WIFI = "WifiWakeLock"

    enum class PersistenceKey {
        IS_LOGIN, TOKEN, LAST_SYNC_DATE, SERVICE_RUNNING
    }
}
