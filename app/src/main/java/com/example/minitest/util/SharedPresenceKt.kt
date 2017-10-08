package com.example.minitest.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


/**
 * Created by Administrator on 2017/10/8.
 */
fun Context.getSharedPresence(name: String): SharedPreferences {
   return getSharedPreferences(name,MODE_PRIVATE)
}

fun SharedPreferences.putBoolean(key: String,value: Boolean){
    edit().putBoolean(key,value)
            .apply()
}

fun SharedPreferences.getBoolean(key: String): Boolean {
   return getBoolean(key,false)
}