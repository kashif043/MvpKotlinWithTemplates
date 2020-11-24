package co.appdev.boilerplate.mvpkotlin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.User
import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?
}