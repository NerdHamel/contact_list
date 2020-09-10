package com.example.stcpaycodingchallenge.baseclasses

interface ISectionController {
    fun setActivityActionButton()
    val isEditable: Boolean
    fun setEditable(): Boolean
}