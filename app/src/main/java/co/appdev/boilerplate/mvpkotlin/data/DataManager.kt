package co.appdev.boilerplate.mvpkotlin.data

import co.appdev.boilerplate.mvpkotlin.data.local.RoomHelper
import co.appdev.boilerplate.mvpkotlin.data.local.SharedPrefHelper
import co.appdev.boilerplate.mvpkotlin.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(
    private val apiService: ApiService,
    private val sharedPrefHelper: SharedPrefHelper,
    private val roomHelper: RoomHelper
) {

    fun geApiService(): ApiService {
        return apiService
    }

    fun getSharedPrefHelper(): SharedPrefHelper {
        return sharedPrefHelper
    }

    fun getRoomHelper(): RoomHelper {
        return roomHelper
    }

}