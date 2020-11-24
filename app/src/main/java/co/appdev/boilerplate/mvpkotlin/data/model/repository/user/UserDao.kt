package co.appdev.boilerplate.mvpkotlin.data.model.repository.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(userList: List<User?>?)

    @Query("SELECT * FROM User")
    fun loadAll(): List<User?>?
}