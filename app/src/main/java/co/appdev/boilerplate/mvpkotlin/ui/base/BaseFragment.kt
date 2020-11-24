package co.appdev.boilerplate.mvpkotlin.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import co.appdev.boilerplate.mvpkotlin.injection.component.ActivityComponent

abstract class BaseFragment<B : ViewDataBinding?> : Fragment(), View.OnClickListener {

    var dataBinding: B? = null
    var parent: View? = null
    var mActivity: BaseActivity<*>? = null
    var mFragNavigation: FragmentNavigation? = null

    private var mInt = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            mInt = args.getInt(ARGS_INSTANCE)
        }
    }

    val activityComponent: ActivityComponent? get() = if (mActivity != null) { mActivity!!.activityComponent() } else null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            mActivity = context
            mFragNavigation = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate<B>(inflater, layoutId, container, false)
        parent = dataBinding!!.root
        parent!!.setOnClickListener(this)
        initViews(parent)
        return parent
    }

    abstract val layoutId: Int
    abstract fun initViews(parentView: View?)

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    interface FragmentNavigation {
        fun pushFragment(fragment: Fragment?)
        fun replaceFragment(fragment: Fragment?)
        fun navigationTitle(fragment: Fragment?)
        fun popFragment()
        fun switchTab(tabNumber: Int)
        fun showDialogFragment(dialogFragment: DialogFragment?)
        fun clearDialogFragment()
        fun popFragment(count: Int)
    }

    companion object {
        const val ARGS_INSTANCE = "co.appdev.boilerplate.mvpkotlin.argsInstance"
    }
}