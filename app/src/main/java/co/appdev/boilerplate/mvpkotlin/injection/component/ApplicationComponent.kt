package co.appdev.boilerplate.mvpkotlin.injection.component

import androidx.databinding.ViewDataBinding
import co.appdev.boilerplate.mvpkotlin.data.DataManager
import co.appdev.boilerplate.mvpkotlin.data.local.RoomHelper
import co.appdev.boilerplate.mvpkotlin.data.local.SharedPrefHelper
import co.appdev.boilerplate.mvpkotlin.injection.module.ApplicationModule
import co.appdev.boilerplate.mvpkotlin.injection.module.NetworkModule
import co.appdev.boilerplate.mvpkotlin.injection.module.SharedPreferencesModule
import co.appdev.boilerplate.mvpkotlin.ui.base.BaseActivity
import co.appdev.boilerplate.mvpkotlin.ui.base.BaseFragment
import co.appdev.boilerplate.mvpkotlin.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class, SharedPreferencesModule::class))
interface ApplicationComponent {
    fun dataManager(): DataManager?
    fun sharedPrefHelper(): SharedPrefHelper?
    fun roomHelper(): RoomHelper?
    fun inject(baseFragment: BaseFragment<ViewDataBinding?>?)
    fun inject(baseActivity: BaseActivity<ViewDataBinding?>?)
    fun inject(splashActivity: SplashActivity?);
}