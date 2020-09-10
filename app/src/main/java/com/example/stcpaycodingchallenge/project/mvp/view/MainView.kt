package com.example.stcpaycodingchallenge.project.mvp.view

import com.example.stccodingchallenge.baseclasses.NHCActivityViewBase
import com.example.stcpaycodingchallenge.project.activities.MainActivity
import com.example.stcpaycodingchallenge.project.data.adapters.SenateListAdapter
import com.example.stcpaycodingchallenge.project.data.entities.Senator
import com.example.stcpaycodingchallenge.project.data.entities.SenatorListResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainView(val ac: MainActivity) : NHCActivityViewBase(ac) {

    var senators: List<Senator>? = null

    fun showSenateList(senatorss: List<Senator>?) {
        senatorss.let { senators = senatorss }
        senators?.let { ac?.rcvSenators?.adapter = SenateListAdapter(it.sortedBy { it?.person?.sortname },this) }
    }


    init {

        //TODO set activity UI related things here
        /*
        ac?.exampleBUttonName.setOnClickListener { <code here> }
        */

    }


//TODO put all UI events and functions here (request methods will call from ac.presnter, response methods will get triggered by the presenter)

/*
    private fun somRequestFunctionExample() {
    ac?.presenter?.Function(data value)
    }
*/
}
