package co.appdev.boilerplate.mvpkotlin.data.model

import com.google.gson.annotations.SerializedName

class LoginResponse{

    @SerializedName("status_code")
    var statusCode = 0

    @SerializedName("data")
    var data: LoginData? = null

    @SerializedName("error")
    var isError = false

    @SerializedName("message")
    var message: String? = null

    override fun toString(): String {
        return "LoginResponse{" +
                "status_code = '" + statusCode + '\'' +
                ",data = '" + data + '\'' +
                ",error = '" + isError + '\'' +
                ",message = '" + message + '\'' +
                "}"
    }
}