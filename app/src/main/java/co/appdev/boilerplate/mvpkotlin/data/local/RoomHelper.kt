package co.appdev.boilerplate.mvpkotlin.data.local

import android.content.Context
import androidx.room.Room
import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.UserRepo
import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.UserRepository
import co.appdev.boilerplate.mvpkotlin.injection.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomHelper @Inject constructor(@ApplicationContext context: Context?) {
    private var appDatabase: AppDatabase = Room.databaseBuilder(context!!, AppDatabase::class.java, "APP_DB_NAME")
        .allowMainThreadQueries().build()

    val userRepo: UserRepo get() = UserRepository(appDatabase.userDao())
}