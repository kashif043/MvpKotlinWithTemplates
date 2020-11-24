package co.appdev.boilerplate.mvpkotlin.util

import io.reactivex.disposables.CompositeDisposable


object RxUtil {
    fun dispose(disposable: CompositeDisposable?) {
        if (disposable != null && !disposable.isDisposed) {
            disposable.clear()
        }
    }
}