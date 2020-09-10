package com.example.stcpaycodingchallenge.project.mvp.presenter

import com.example.stccodingchallenge.baseclasses.NHCActivityPresenterBase

import com.example.stcpaycodingchallenge.project.mvp.model.MainModel
import com.example.stcpaycodingchallenge.project.mvp.view.MainView

class MainPresenter(view: MainView, model: MainModel) :
    NHCActivityPresenterBase<MainView, MainModel>(view, model) {


    fun loadSenateData() {
        view.showSenateList(model.loadSenateData(view.ac));
    }


//
//    @Subscribe
//    fun exampleResponseEventFunction (event: SenatorListResponse) {
//        view.showSenateList(event?.objects)
//    }

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
