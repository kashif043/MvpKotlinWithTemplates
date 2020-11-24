package co.appdev.boilerplate.mvpkotlin.injection.module

import android.app.Activity
import android.content.Context
import co.appdev.boilerplate.mvpkotlin.injection.ActivityContext
import dagger.Module
import dagger.Provides
/**
 * Provide activity-level dependencies.
 */
@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    @ActivityContext
    fun providesContext(): Context {
        return mActivity
    }

}