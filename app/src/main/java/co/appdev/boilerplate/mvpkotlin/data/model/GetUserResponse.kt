package co.appdev.boilerplate.mvpkotlin.data.model

import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.User
import com.google.gson.annotations.SerializedName

class GetUsersResponse {
    @SerializedName("Users")
    private var users: List<User>? = null

    fun setUsers(users: List<User>?) {
        this.users = users
    }

    fun getUsers(): List<User>? {
        return users
    }

    override fun toString(): String {
        return "User{" +
                "users = '" + users + '\'' +
                "}"
    }
}