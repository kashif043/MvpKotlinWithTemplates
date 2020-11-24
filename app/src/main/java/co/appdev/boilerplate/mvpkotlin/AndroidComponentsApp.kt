package co.appdev.boilerplate.mvpkotlin

import android.app.Application
import android.content.Context
import co.appdev.boilerplate.mvpkotlin.injection.component.ApplicationComponent
import co.appdev.boilerplate.mvpkotlin.injection.component.DaggerApplicationComponent
import co.appdev.boilerplate.mvpkotlin.injection.module.ApplicationModule
import timber.log.Timber

class AndroidComponentsApp : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    fun getComponent(): ApplicationComponent? {
            if (mApplicationComponent == null) {
                mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(this))
                    .build()
            }
            return mApplicationComponent
        }

    fun setComponent(applicationComponent: ApplicationComponent) { mApplicationComponent = applicationComponent }

    companion object {
        fun get(context: Context): AndroidComponentsApp {
            return context.applicationContext as AndroidComponentsApp
        }
    }
}