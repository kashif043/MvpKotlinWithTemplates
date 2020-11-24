package co.appdev.boilerplate.mvpkotlin.data.model

import com.google.gson.annotations.SerializedName

class LoginData {
    @SerializedName("business_name")
    var businessName: String? = null

    @SerializedName("updated_at")
    var updatedAt: String? = null

    @SerializedName("business_type")
    var businessType: String? = null

    @SerializedName("mobile")
    var mobile: String? = null

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("id")
    var id = 0

    @SerializedName("status")
    var status: String? = null

    override fun toString(): String {
        return "Data{" +
                "business_name = '" + businessName + '\'' +
                ",updated_at = '" + updatedAt + '\'' +
                ",business_type = '" + businessType + '\'' +
                ",mobile = '" + mobile + '\'' +
                ",created_at = '" + createdAt + '\'' +
                ",id = '" + id + '\'' +
                ",status = '" + status + '\'' +
                "}"
    }
}