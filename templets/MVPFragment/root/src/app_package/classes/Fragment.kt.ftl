package ${packageName}.${folderName}

import android.view.View
import ${applicationPackage}.ui.base.BaseFragment
<#if applicationPackage??>
import ${applicationPackage}.R
</#if>
import ${applicationPackage}.databinding.${layoutName?replace('_', ' ')?capitalize?replace(' ','')}Binding
import javax.inject.Inject

class ${activityClass} : BaseFragment<${layoutName?replace('_', ' ')?capitalize?replace(' ','')}Binding?>() , ${className}MvpView {

    @Inject
    lateinit var mPresenter: ${className}Presenter<${className}MvpView>

     override fun initViews(parentView: View?) {
        activityComponent!!.inject(this)
        mPresenter.attachView(this@${className}Fragment)
        dataBinding!!.listener

        mPresenter.loadData()
     }

    override val layoutId: Int get() = R.layout.${layoutName}

     override fun onDestroy() {
         mPresenter.detachView()
         super.onDestroy()
     }

     override fun showTask() {
        TODO("Not yet implemented")
     }

     override fun onClick(v: View?) {}
}
