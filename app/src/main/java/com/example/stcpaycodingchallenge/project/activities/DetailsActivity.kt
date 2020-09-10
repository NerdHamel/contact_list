package com.example.stcpaycodingchallenge.project.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.view.ViewGroup
import com.example.stccodingchallenge.baseclasses.NHCActivityBase
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.project.mvp.model.DetailsModel
import com.example.stcpaycodingchallenge.project.mvp.presenter.DetailsPresenter
import com.example.stcpaycodingchallenge.project.mvp.view.DetailsView

class DetailsActivity : NHCActivityBase<DetailsModel, DetailsView, DetailsPresenter>() {
    override val containerId: Int = 0

    override val container: ViewGroup? = null

    override var showToolBar: Boolean = false

    override var sharedPreferences: SharedPreferences? = null


    var needsRefresh = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        presenter = DetailsPresenter(
            DetailsView(this),
            DetailsModel()
        )


    }

    override fun onResume() {
        super.onResume()

    }}
