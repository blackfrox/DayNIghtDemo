package com.example.minitest

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.minitest.ui.SettingsActivity
import com.example.minitest.util.displayDayNight
import com.example.minitest.util.getBoolean
import com.example.minitest.util.getSharedPresence
import com.example.minitest.util.putBoolean
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/10/8.
 */
class App: Application(){
    var instance: App by Delegates.notNull<App>()

    companion object {
        val THEME="theme"
        val NIGHT_THEME ="night_theme"
        val LIGHT_THEME="light_theme"
        val RECREATE_ACTIVITY="recreate_activity"
        val THEME_SAVED="theme_saved"

    }
    override fun onCreate() {
        super.onCreate()
        instance=this

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                (activity as AppCompatActivity).displayDayNight()

            }

            override fun onActivityPaused(activity: Activity?) {

            }

            override fun onActivityResumed(activity: Activity?) {
                when(activity){
                    is MainActivity ->{
                        val preference=activity.getSharedPresence(App.THEME)
                        if (preference.getBoolean(App.RECREATE_ACTIVITY)){
                            preference.putBoolean(App.RECREATE_ACTIVITY,false)
                            activity.recreate()
                        }
                    }
                }
            }

            override fun onActivityStarted(activity: Activity?) {

            }

            override fun onActivityDestroyed(activity: Activity?) {

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

            }

            override fun onActivityStopped(activity: Activity?) {

            }



        })
    }


}