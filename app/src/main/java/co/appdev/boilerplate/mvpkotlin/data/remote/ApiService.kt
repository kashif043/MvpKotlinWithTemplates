package co.appdev.boilerplate.mvpkotlin.data.remote

import co.appdev.boilerplate.mvpkotlin.data.model.GetUsersResponse
import io.reactivex.Observable
import retrofit2.http.POST

interface ApiService {

    companion object {
        const val BASE_URL = "http://www.mocky.io/"
        private const val API_LEVEL = ""
        private const val VERSION = "v2/"
        const val API_GET_USERS = API_LEVEL + VERSION + "5dbff23c3100006d73be3cd0"
    }

    @POST(API_GET_USERS)
    fun getUsers() : Observable<GetUsersResponse?>?
}