package com.example.stcpaycodingchallenge.baseclasses.Util


import android.app.Application
import android.content.Context
import android.view.WindowManager
import com.example.stccodingchallenge.baseclasses.NHCActivityBase

/**
 * Created by blckd on 5/26/2017.
 */

class App : Application() {


    override fun onCreate() {
        super.onCreate()
//        Fabric.with(this, Crashlytics())
        appContext = this

    }




    companion object {

        var appContext: Context? = null
            private set
        var currentActivity: NHCActivityBase<*, *, *>? = null
        private val isProgressDialogShowing = false

        @JvmOverloads
        fun showProgressDialog(activity: NHCActivityBase<*, *, *>? = currentActivity) {

            setProgressVisibility(activity, true)

        }

        @JvmOverloads
        fun hideProgressDialog(activity: NHCActivityBase<*, *, *>? = currentActivity) {
            setProgressVisibility(activity, false)
        }

        fun setProgressVisibility(activity: NHCActivityBase<*, *, *>?, makeVisible: Boolean) {

            if (activity != null) {
                //            ac.runOnUiThread(new Runnable() {
                //                @Override
                //                public void run() {
                //                    if (makeVisible) {
                //                        if (!ac.getDialogFragment().isVisible())
                //                            ac.getDialogFragment().show(ac.getFragmentManager(), ac.getFragmentTag());
                //                    } else {
                //
                //                        if (ac.getDialogFragment().isVisible())
                //                            ac.getDialogFragment().dismissAllowingStateLoss();
                //
                //
                //                    }

                //                }
                //            });
            }

        }


        fun showAlertDialog(s: String) {

        }

        val screenWidth: Int
            get() = (appContext!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.width

        val screenHeight: Int
            get() = (appContext!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.height
    }
}
