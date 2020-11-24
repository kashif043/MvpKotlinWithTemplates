package ${packageName}.${folderName}

import android.os.Bundle
import javax.inject.Inject
import ${applicationPackage}.ui.base.BaseActivity
import android.content.Intent
import android.content.Context
<#if applicationPackage??>
import ${applicationPackage}.R
</#if>
 import ${applicationPackage}.databinding.${layoutName?replace('_', ' ')?capitalize?replace(' ','')}Binding

class ${className}Activity : BaseActivity<${layoutName?replace('_', ' ')?capitalize?replace(' ','')}Binding?>() , ${className}MvpView {

	@Inject
    lateinit var mPresenter: ${className}Presenter<${className}MvpView>

    override fun initViews(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent()?.inject(this)
        mPresenter.attachView(this@${className}Activity)
        dataBinding!!.listener

        mPresenter.loadData()
    }

    companion object {
        fun getStartIntent(context: Context?): Intent {
            return Intent(context, ${className}Activity::class.java)
        }
    }

    override val layoutId: Int get() = R.layout.${layoutName}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }

    override fun showTask() {
        TODO("Not yet implemented")
    }

}