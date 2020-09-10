package com.example.stcpaycodingchallenge.project.mvp.presenter

import com.example.stccodingchallenge.baseclasses.NHCActivityPresenterBase

import com.example.stcpaycodingchallenge.project.mvp.model.DetailsModel
import com.example.stcpaycodingchallenge.project.mvp.view.DetailsView

class DetailsPresenter(view: DetailsView, model: DetailsModel) :
    NHCActivityPresenterBase<DetailsView, DetailsModel>(view, model) {

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
