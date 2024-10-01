package com.geovannycode.jetpackcompose.ecoeats.data.util

import android.content.SharedPreferences

object Util {

    fun saveTokenSharePreferences(sharedPreferences: SharedPreferences, data:String){
        sharedPreferences.edit().putString("KEY_TOKEN", data).apply()
    }

    fun SharedPreferences.save(data:String){
        this.edit().putString("KEY_TOKEN", data).apply()
    }

    fun SharedPreferences.getToken(): String{
        return this.getString("KEY_TOKEN","") ?: ""
    }
}