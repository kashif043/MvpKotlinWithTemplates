package co.appdev.boilerplate.mvpkotlin.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.appdev.boilerplate.mvpkotlin.R
import co.appdev.boilerplate.mvpkotlin.data.model.repository.user.User
import co.appdev.boilerplate.mvpkotlin.databinding.ActivityHomeBinding
import co.appdev.boilerplate.mvpkotlin.ui.base.BaseActivity
import co.appdev.boilerplate.mvpkotlin.util.DialogUtils
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding?>(), HomeMvpView {

    @Inject
    lateinit var mPresenter: HomePresenter<HomeMvpView>
    @Inject
    lateinit var mUsersAdapter: UsersAdapter

    override fun initViews(savedInstanceState: Bundle?) {
        activityComponent()?.inject(this)
        mPresenter.attachView(this@HomeActivity)
        dataBinding!!.listener
        dataBinding!!.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        dataBinding!!.recyclerView.adapter = mUsersAdapter

        mPresenter.loadData()
    }

    companion object {
        fun getStartIntent(context: Context?): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override val layoutId: Int get() = R.layout.activity_home

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

    override fun showUser(users : List<User?>?) {
        mUsersAdapter.setRibots(users = users as List<User>)
        mUsersAdapter.notifyDataSetChanged()
    }

    override fun showError() {
        DialogUtils.createGenericErrorDialog(this, getString(R.string.error_loading_ribots)).show()
    }
}