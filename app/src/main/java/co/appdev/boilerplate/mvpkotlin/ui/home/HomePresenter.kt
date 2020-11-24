package co.appdev.boilerplate.mvpkotlin.ui.home

import co.appdev.boilerplate.mvpkotlin.data.DataManager
import co.appdev.boilerplate.mvpkotlin.ui.base.BasePresenter
import co.appdev.boilerplate.mvpkotlin.util.RxUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter<V : HomeMvpView?> @Inject constructor(dataManager: DataManager?) :
    BasePresenter<V>(), HomeMvpPresenter {

    private var mDisposable: CompositeDisposable? = null
    private val mDataManager: DataManager?

    init {
        mDataManager = dataManager
        if (mDisposable == null) {
            mDisposable = CompositeDisposable()
        }
    }

    override fun detachView() {
        super.detachView()
        mDisposable?.dispose()
        mDisposable = null
    }

    override fun getTask() {
        TODO("Not yet implemented")
    }

    fun loadData() {
        if (!mDataManager!!.getRoomHelper().userRepo.isUserRepoEmpty) {
            getMvpView()!!.showUser(mDataManager.getRoomHelper().userRepo.loadUsers())
            return
        }
        checkViewAttached()
        RxUtil.dispose(mDisposable)
        mDisposable!!.add(
            mDataManager.geApiService().getUsers()!!
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ getUsersResponse ->
                    if (mDataManager.getRoomHelper().userRepo.isUserRepoEmpty) {
                        mDataManager.getRoomHelper().userRepo.insertUsers(getUsersResponse!!.getUsers())
                    }
                    getMvpView()!!.showUser(getUsersResponse!!.getUsers())
                }, { getMvpView()!!.showError() })
        )
    }
}