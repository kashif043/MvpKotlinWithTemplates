package co.appdev.boilerplate.mvpkotlin.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.appdev.boilerplate.mvpkotlin.R
import co.appdev.boilerplate.mvpkotlin.ui.home.HomeActivity
import co.appdev.boilerplate.mvpkotlin.util.ConstantsUtil.SPLASH_TIME_OUT
import io.reactivex.Maybe
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Maybe.empty<Any>()
            .delay(SPLASH_TIME_OUT.toLong(), TimeUnit.SECONDS)
            .doOnComplete {
                startActivity(HomeActivity.getStartIntent(this))
                finish()
            }
            .subscribe()
    }
}