package com.example.stcpaycodingchallenge.project.mvp.view

import com.example.stccodingchallenge.baseclasses.NHCActivityViewBase
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase.Companion.gson
import com.example.stcpaycodingchallenge.project.activities.DetailsActivity
import com.example.stcpaycodingchallenge.project.data.entities.Senator
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_details.imgvLogo
import kotlinx.android.synthetic.main.activity_details.txtvName
import kotlinx.android.synthetic.main.controller_list_item.*
import kotlinx.android.synthetic.main.controller_list_item.view.*

class DetailsView(val ac: DetailsActivity) : NHCActivityViewBase(ac) {


    var senator: Senator? = null

    init {
        ac?.imgvBack?.setOnClickListener { ac?.onBackPressed() }

        var item = Gson().fromJson(ac?.intent.getStringExtra("item"), Senator::class.java)

        senator = item

        //TODO set activity UI related things here
        /*
        ac?.exampleBUttonName.setOnClickListener { <code here> }
        */

        ac?.txtvName?.text = "${senator?.person?.firstname}  ${senator?.person?.lastname}"
        ac?.txtvEmail?.text = senator?.person?.link
        ac?.txtvbgidv?.text = senator?.person?.bioguideid
        ac?.txtvDescription?.text = senator?.description

        ac?.imgvLogo?.setImageResource(if (senator?.party == "Republican") R.drawable.republican_logo else R.drawable.democrat_logo)
        ac?.txtvAddressv?.text = senator?.extra?.address
        ac?.txtvOfficev?.text = senator?.extra?.office
        ac?.txtvnamev?.text = senator?.person?.name
        ac?.txtvbirthdayv?.text = senator?.person?.birthday
        ac?.txtvenddatev?.text = senator?.enddate
        ac?.txtvgenderv?.text = senator?.person?.gender_label
        ac?.txtvSortNamev?.text = senator?.person?.sortname
        ac?.txtvWebsitev?.text = senator?.website


    }


//TODO put all UI events and functions here (request methods will call from ac.presnter, response methods will get triggered by the presenter)

/*
    private fun somRequestFunctionExample() {
    ac?.presenter?.Function(data value)
    }
*/
}
