package ${packageName}.${folderName}

import ${applicationPackage}.ui.base.BasePresenter
import ${applicationPackage}.data.DataManager
import ${applicationPackage}.util.RxUtil
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ${className}Presenter <V : ${className}MvpView?> @Inject constructor(dataManager: DataManager?) : BasePresenter<V>(), ${className}MvpPresenter {

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
        checkViewAttached()
        RxUtil.dispose(mDisposable)
        getMvpView()!!.showTask()
    }
}