package com.example.stcpaycodingchallenge.project.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.view.ViewGroup
import com.example.stccodingchallenge.baseclasses.NHCActivityBase
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.project.mvp.model.MainModel
import com.example.stcpaycodingchallenge.project.mvp.presenter.MainPresenter
import com.example.stcpaycodingchallenge.project.mvp.view.MainView

class MainActivity : NHCActivityBase<MainModel, MainView, MainPresenter>() {
    override val containerId: Int = 0

    override val container: ViewGroup? = null

    override var showToolBar: Boolean = false

    override var sharedPreferences: SharedPreferences? = null


    var needsRefresh = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter = MainPresenter(
            MainView(this),
            MainModel()
        )


    }

    override fun onResume() {
        super.onResume()

    }}
