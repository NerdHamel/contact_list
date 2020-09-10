package com.example.stcpaycodingchallenge.baseclasses

abstract class ActionClickEvent {
    abstract fun onActionButtonClicked()
    abstract val drawableResourceId: Int
}