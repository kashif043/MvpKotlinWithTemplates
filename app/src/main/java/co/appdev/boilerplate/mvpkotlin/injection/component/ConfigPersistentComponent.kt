package co.appdev.boilerplate.mvpkotlin.injection.component

import co.appdev.boilerplate.mvpkotlin.injection.ConfigPersistent
import co.appdev.boilerplate.mvpkotlin.injection.module.ActivityModule
import dagger.Component

/**
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * be destroy during configuration changes. Check [BaseActivity] to see how this components
 * survives configuration changes.
 * Use the [ConfigPersistent] scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */

@ConfigPersistent
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ConfigPersistentComponent {
    fun activityComponent(activityModule : ActivityModule?): ActivityComponent?
}