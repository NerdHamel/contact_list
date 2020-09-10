package com.example.stcpaycodingchallenge.baseclasses

import com.google.gson.Gson
import com.nerdscorner.mvplib.events.model.BaseEventsModel

open class NHCModelBase : BaseEventsModel(){
    companion object{

        val gson: Gson =Gson();
    }

}
