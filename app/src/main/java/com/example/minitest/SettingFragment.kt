package com.example.minitest

import android.app.Fragment
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import com.example.minitest.util.getSharedPresence

/**
 * Created by Administrator on 2017/10/8.
 */
class SettingFragment: PreferenceFragment(),SharedPreferences.OnSharedPreferenceChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref_setting)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String) {
        val nightMode=resources.getString(R.string.NightMode)
        when(key){
            nightMode ->{
                val themePreferences=activity.getSharedPresence(App.THEME)
                val editorTheme=themePreferences.edit()
                //We tell our MainLayout to recreate itself because mode has changed
                editorTheme.putBoolean(App.RECREATE_ACTIVITY,true)

                val preferencesSwitch=findPreference(nightMode) as SwitchPreference
               if (preferencesSwitch.isChecked){
                   editorTheme.putString(App.THEME_SAVED,App.LIGHT_THEME)
               }else{
                   editorTheme.putString(App.THEME_SAVED,App.NIGHT_THEME)
               }
                editorTheme.apply()
                activity.recreate()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        preferenceManager.sharedPreferences
                .registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPause() {
        super.onPause()
        preferenceManager.sharedPreferences
                .unregisterOnSharedPreferenceChangeListener(this)
    }
}