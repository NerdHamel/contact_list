package com.example.stcpaycodingchallenge.project.mvp.model

import android.content.Context
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase
import com.example.stcpaycodingchallenge.project.data.entities.SenatorListResponse
import java.io.InputStream

class MainModel : NHCModelBase() {
    fun loadSenateData(context: Context): SenatorListResponse? {
        var inputStream: InputStream = context.resources.openRawResource(R.raw.us_senators)
        var jsonString = inputStream.bufferedReader().use { it.readText() }

        var response = gson.fromJson(jsonString, SenatorListResponse::class.java)
        return response
    }


//TODO implement functions here

}
