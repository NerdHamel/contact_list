package com.example.stcpaycodingchallenge.project.mvp.presenter

import com.example.stccodingchallenge.baseclasses.NHCActivityPresenterBase
import com.example.stcpaycodingchallenge.baseclasses.DataLoadEvent
import com.example.stcpaycodingchallenge.project.data.entities.SenatorListResponse

import com.example.stcpaycodingchallenge.project.mvp.model.MainModel
import com.example.stcpaycodingchallenge.project.mvp.view.MainView
import org.greenrobot.eventbus.Subscribe

class MainPresenter(view: MainView, model: MainModel) :
    NHCActivityPresenterBase<MainView, MainModel>(view, model) {


    fun loadSenateData() {

        if (view.senators == null || view.senators?.size == 0)
            model.loadSenateData(view.ac);

    }

    override fun onResume() {
        super.onResume()
        loadSenateData()
    }


    @Subscribe
    fun exampleResponseEventFunction(event: SenatorListResponse) {
        view.showSenateList(event?.objects)
    }



//TODO facilitate message passing based on example below
    /*
    fun exampleRequestFunction() {
        model.exampleRequestFunction1()
    }

    @Subscribe
    fun exampleResponseEventFunction (event: ExampleEventDataObjectType) {
        view.pefrormsomeViewUpdate(event.data)
    }
*/

}
