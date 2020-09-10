package com.example.stccodingchallenge.baseclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat.getColor
import com.example.stcpaycodingchallenge.R
import com.nerdscorner.mvplib.events.fragment.BaseFragment
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter
import com.nerdscorner.mvplib.events.view.BaseFragmentView
import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase


abstract class NHCFragmentBase<M : NHCModelBase, V : BaseFragmentView, P : BaseFragmentPresenter<V, M>> : BaseFragment<BaseFragmentPresenter<V, M>>() {

    protected lateinit var inflater: LayoutInflater
    protected var container: ViewGroup? = null
    protected var savedInstanceState: Bundle? = null
    lateinit var rootView: View
        protected set
    lateinit protected var model: M
    lateinit protected var fView: V

    abstract val layoutId: Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        this.inflater = inflater
        this.container = container
        this.savedInstanceState = savedInstanceState


        super.onCreateView(inflater, container, savedInstanceState)

        iflateChildView(layoutId)
        model = createModel()
        fView = createView()
        presenter = createPresenter()
        rootView.setBackgroundColor(getColor(requireActivity(), R.color.transparent))

        onCreateViewImplementation()
//        if (this is ISectionController) {
//            (this as ISectionController).setActivityActionButton()
//        }

        (fView as NHCFragmentViewBase).init()
        return rootView
    }

    protected abstract fun createPresenter(): P


    protected abstract fun createView(): V

    protected abstract fun createModel(): M

    protected fun iflateChildView(@LayoutRes layoutId: Int): View {
        rootView = inflater.inflate(layoutId, container, false)
        return rootView
    }

    protected abstract fun onCreateViewImplementation()
}
