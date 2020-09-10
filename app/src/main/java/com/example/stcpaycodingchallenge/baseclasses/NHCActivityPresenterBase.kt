package com.example.stccodingchallenge.baseclasses

import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import org.greenrobot.eventbus.Subscribe


abstract class NHCActivityPresenterBase<V : NHCActivityViewBase, M : NHCModelBase>(view: V, model: M) : BaseActivityPresenter<V, M>(view, model) {


//    @Subscribe
//    abstract fun onDatatLoaded(event: DataLoadEvent)
}