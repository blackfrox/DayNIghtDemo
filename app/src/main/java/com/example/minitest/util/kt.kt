package com.example.minitest.util

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.example.minitest.App

/**
 * Created by Administrator on 2017/10/8.
 */

fun AppCompatActivity.displayDayNight(){
    val presence=getSharedPresence(App.THEME)
    if (presence.getString(App.THEME_SAVED,App.NIGHT_THEME)==App.LIGHT_THEME){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }else{
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}