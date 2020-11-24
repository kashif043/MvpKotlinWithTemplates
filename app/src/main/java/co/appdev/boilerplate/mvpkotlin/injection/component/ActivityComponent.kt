package co.appdev.boilerplate.mvpkotlin.injection.component

import co.appdev.boilerplate.mvpkotlin.injection.PerActivity
import co.appdev.boilerplate.mvpkotlin.injection.module.ActivityModule
import co.appdev.boilerplate.mvpkotlin.ui.home.HomeActivity
import co.appdev.boilerplate.mvpkotlin.ui.splash.SplashActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject (homeActivity: HomeActivity?)
}