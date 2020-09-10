package com.example.stccodingchallenge.baseclasses

import com.example.stcpaycodingchallenge.baseclasses.DataLoadEvent
import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter
import org.greenrobot.eventbus.Subscribe


abstract class NHCFragmentPresenterBase<V : NHCFragmentViewBase, M : NHCModelBase>(view: V, model: M) : BaseFragmentPresenter<V, M>(view, model) {
    @Subscribe
    abstract fun onDatatLoaded(event: DataLoadEvent)

}
