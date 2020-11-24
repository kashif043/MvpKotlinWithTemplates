package co.appdev.boilerplate.mvpkotlin.ui.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.LongSparseArray
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import co.appdev.boilerplate.mvpkotlin.AndroidComponentsApp
import co.appdev.boilerplate.mvpkotlin.R
import co.appdev.boilerplate.mvpkotlin.injection.component.ActivityComponent
import co.appdev.boilerplate.mvpkotlin.injection.component.ConfigPersistentComponent
import co.appdev.boilerplate.mvpkotlin.injection.component.DaggerConfigPersistentComponent
import co.appdev.boilerplate.mvpkotlin.injection.module.ActivityModule
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavController.TransactionListener
import com.ncapdevi.fragnav.FragNavController.TransactionType
import timber.log.Timber
import java.util.concurrent.atomic.AtomicLong

abstract class BaseActivity<B : ViewDataBinding?> : AppCompatActivity(), View.OnClickListener,
    BaseFragment.FragmentNavigation, TransactionListener {

    var dataBinding: B? = null
    var mNavController: FragNavController? = null
    var mActivityComponent: ActivityComponent? = null
    var mActivityId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()
        val configPersistentComponent: ConfigPersistentComponent?
        if (!S_COMPONENT_NAME.containsKey(mActivityId)) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", mActivityId)
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                .applicationComponent(AndroidComponentsApp.get(this).getComponent())
                .build()
            S_COMPONENT_NAME.put(mActivityId, configPersistentComponent)
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", mActivityId)
            configPersistentComponent = S_COMPONENT_NAME[mActivityId]
        }
        mActivityComponent = configPersistentComponent?.activityComponent(ActivityModule(this))
        dataBinding = DataBindingUtil.setContentView<B>(this,layoutId)
        initViews(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong(
            KEY_ACTIVITY_ID,
            mActivityId
        )
    }

    override fun onBackPressed() {
        if (mNavController != null && mNavController!!.currentStack!!.size > 1) {
            mNavController!!.popFragment()
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", mActivityId)
            S_COMPONENT_NAME.remove(mActivityId)
        }
        super.onDestroy()
    }

    fun activityComponent(): ActivityComponent? {
        return mActivityComponent
    }

    abstract fun initViews(savedInstanceState: Bundle?)
    abstract val layoutId: Int

    override fun switchTab(tabNumber: Int) {
        if (mNavController != null) {
            mNavController!!.switchTab(tabNumber)
        }
    }

    override fun pushFragment(fragment: Fragment?) {
        if (mNavController != null) {
            mNavController!!.pushFragment(fragment)
        }
    }

    override fun replaceFragment(fragment: Fragment?) {
        if (mNavController != null) {
            mNavController!!.replaceFragment(fragment!!)
        }
    }

    override fun popFragment() {
        if (mNavController != null) {
            mNavController!!.popFragment()
        }
    }

    override fun showDialogFragment(dialogFragment: DialogFragment?) {
        if (mNavController != null) {
            mNavController!!.showDialogFragment(dialogFragment)
        }
    }

    override fun clearDialogFragment() {
        if (mNavController != null) {
            mNavController!!.clearDialogFragment()
        }
    }

    override fun popFragment(count: Int) {
        if (mNavController != null) {
            mNavController!!.popFragments(count)
        }
    }

    override fun onClick(view: View) {}

    override fun navigationTitle(fragment: Fragment?) {}

    override fun onTabTransaction(fragment: Fragment?, index: Int) {}

    override fun onFragmentTransaction(
        fragment: Fragment?,
        transactionType: TransactionType
    ) {
    }

    companion object {
        private const val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
        private val NEXT_ID = AtomicLong(0)
        private val S_COMPONENT_NAME: LongSparseArray<ConfigPersistentComponent?> = LongSparseArray()
    }
}