package com.example.minitest.ui

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.preference.RingtonePreference
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.MenuItem
import com.example.minitest.R
import com.example.minitest.SettingFragment
import com.example.minitest.util.displayDayNight

/**

 */
class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_setting)
        fragmentManager.beginTransaction()
                .replace(R.id.container,SettingFragment())
                .commit()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
       when(item?.itemId){
           android.R.id.home -> {
               onBackPressed()
               finish()
               return  true
           }
           else -> return super.onOptionsItemSelected(item)
       }
    }
}
