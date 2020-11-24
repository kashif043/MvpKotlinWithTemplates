package co.appdev.boilerplate.mvpkotlin.data.model.repository.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "User")
class User {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String? = null

    @SerializedName("age")
    @ColumnInfo(name = "age")
    var age = 0

    override fun toString(): String {
        return "UsersItem{" +
                "name = '" + name + '\'' +
                ",age = '" + age + '\'' +
                "}"
    }
}