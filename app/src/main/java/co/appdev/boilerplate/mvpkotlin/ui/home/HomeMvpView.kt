package co.appdev.boilerplate.mvpkotlin.ui.home

import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.User
import co.appdev.boilerplate.mvpkotlin.ui.base.MvpView

interface HomeMvpView : MvpView {
    fun showUser(users : List<User?>?)
    fun showError()
}