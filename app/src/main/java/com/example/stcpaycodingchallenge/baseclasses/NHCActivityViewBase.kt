package com.example.stccodingchallenge.baseclasses

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import com.nerdscorner.mvplib.events.view.BaseActivityView


abstract class NHCActivityViewBase(activity: NHCActivityBase<*, *, *>) : BaseActivityView(activity) {

    val vibrator = activity?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    init {
    }


    fun vibrate(durationInMillis: Long) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(durationInMillis, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(durationInMillis);
        }
    }
}
