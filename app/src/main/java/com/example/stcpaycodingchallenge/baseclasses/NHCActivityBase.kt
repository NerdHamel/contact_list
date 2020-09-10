package com.example.stccodingchallenge.baseclasses

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.drawerlayout.widget.DrawerLayout
import android.view.View
import android.view.ViewGroup
import com.nerdscorner.mvplib.events.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*
import com.example.stcpaycodingchallenge.R
import com.example.stcpaycodingchallenge.baseclasses.NHCModelBase
import com.example.stcpaycodingchallenge.baseclasses.Util.App
import java.lang.reflect.InvocationTargetException
import java.util.*


abstract class NHCActivityBase<M : NHCModelBase, V : NHCActivityViewBase, P : NHCActivityPresenterBase<V, M>> :
    BaseActivity<NHCActivityPresenterBase<V, M>>() {


//    val dialogFragment = ProgressDialogFragment()
    internal var fab: FloatingActionButton? = null
    internal var t = Timer()
    private val fragmentTag: String? = null

    open var showToolBar = true
    open var hasSideNavigation = false

    lateinit var rootView: ViewGroup

    abstract val containerId: Int

    abstract val container: ViewGroup?

    abstract var sharedPreferences: SharedPreferences?

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        App.currentActivity = (this)
        super.setContentView(R.layout.activity_base)
        toolbar.visibility = if (showToolBar) View.VISIBLE else View.GONE


        setLocale(Locale("ar","sa"))


        if (!hasSideNavigation)
            lytDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        rootView = findViewById(R.id.rootView)
        try {
            supportActionBar!!.hide()
        } catch (ex: Exception) {
        }

    }

    override fun onResume() {
        super.onResume()
        App.currentActivity = this

    }

    override fun onStart() {
        super.onStart()}

    override fun onPause() {
        App.hideProgressDialog(this)

        super.onPause()
    }

    fun getFragmentTag(): String {
        return javaClass.simpleName
    }

//    fun setActionButton(event: ActionClickEvent?) {
//
//
//        if (event != null && rootView != null) {
//            if (fab == null) {
//                fab = FloatingActionButton(this)
//                //TODO check for RTL case
//                val layoutParams = RelativeLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//                )
//                layoutParams.setMargins(
//                    (rootView!!.width * 0.7).toInt(),
//                    (rootView!!.height * 0.85).toInt(),
//                    (rootView!!.width * 0.06).toInt(),
//                    0
//                )
//                fab!!.layoutParams = layoutParams
//                (rootView as ViewGroup).addView(fab)
//
//            }
//            if (!fab!!.isShown)
//                fab!!.show()
//
//            try {
//                fab!!.setImageResource(event.drawableResourceId)
//                fab!!.setColorFilter(resources.getColor(R.color.white))
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
//
//            try {
//                fab!!.setOnClickListener { view -> event.onActionButtonClicked() }
//            } catch (ex: Exception) {
//                ex.printStackTrace()
//            }
//
//
//        } else {
//
//            if (fab != null && fab!!.isShown)
//                fab!!.hide()
//        }
//
//
//    }


    //TODO built in timer for splash screen
//    private fun scheduleTimer() {
//        t.schedule(object : TimerTask() {
//            override fun run() {
//
//
//            }
//        }, 2000)
//
//    }


    fun navigateToTarget(target: Class<*>?, params: Bundle? = null) {


        if (target != null) {
            if (NHCFragmentBase::class.java.isAssignableFrom(target)) {
                navigateToFragment(target, params)
            } else {
                //            showToast(R.string.feature_still_under_development);
                if (NHCActivityBase::class.java.isAssignableFrom(target)) {
                    navigateToActivity(target, params, true)
                }

            }
        }
    }

    private fun navigateToActivity(target: Class<*>, params: Bundle?, keepActivity: Boolean) {
        val i = Intent(this, target);

        if (params != null) {
            i.putExtras(params)
        }
        startActivity(i)
        if (!keepActivity) {
            finish()
        }
    }

    private fun navigateToFragment(target: Class<*>, params: Bundle?) {
        try {
            val fragment = target.getDeclaredConstructor().newInstance() as NHCFragmentBase<*, *, *>
            if (params != null) {
                fragment.setArguments(params)
            }
            supportFragmentManager.beginTransaction().replace((this as NHCActivityBase<*, *, *>).containerId, fragment)
                .commitAllowingStateLoss()


        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }


    }

    override fun setContentView(layoutResID: Int) {
        View.inflate(this, layoutResID, rootView)
    }


    private fun setLocale(locale: Locale) {
        val resources = resources
        val configuration = resources.configuration
        val displayMetrics = resources.displayMetrics
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale)
        } else {
            configuration.locale = locale
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            applicationContext.createConfigurationContext(configuration)
        } else {
            resources.updateConfiguration(configuration, displayMetrics)
        }
    }
}
