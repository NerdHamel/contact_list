package com.example.stccodingchallenge.baseclasses

import com.google.gson.Gson
import com.nerdscorner.mvplib.events.view.BaseFragmentView


abstract class NHCFragmentViewBase(fragment: NHCFragmentBase<*, *, *>) : BaseFragmentView(fragment) {

    internal var gson = Gson()

    abstract fun init()
}
