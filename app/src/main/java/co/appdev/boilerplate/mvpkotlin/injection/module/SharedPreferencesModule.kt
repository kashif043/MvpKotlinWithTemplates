package co.appdev.boilerplate.mvpkotlin.injection.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import co.appdev.boilerplate.mvpkotlin.util.ConstantsUtil.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {
    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(
            SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }
}