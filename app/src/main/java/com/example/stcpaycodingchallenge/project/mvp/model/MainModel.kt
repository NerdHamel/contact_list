package com.example.stcpaycodingchallenge.project.mvp.model

import android.content.Context
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase
import com.example.stcpaycodingchallenge.project.data.entities.SenatorListResponse
import kotlinx.coroutines.GlobalScope
import org.greenrobot.eventbus.ThreadMode
import java.io.InputStream

class MainModel : NHCModelBase() {
    fun loadSenateData(context: Context) {
        GlobalScope.run {
            var inputStream: InputStream = context.resources.openRawResource(R.raw.us_senators)
            var jsonString = inputStream.bufferedReader().use { it.readText() }

            var response:SenatorListResponse = gson.fromJson(jsonString, SenatorListResponse::class.java)

            bus.post(response,ThreadMode.MAIN)
        }

    }


//TODO implement functions here

}
