package com.example.hom1mon4.ui.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref (private val context : Context){

    private val pref = context.getSharedPreferences(PREF_NAME,MODE_PRIVATE)



     fun isUserSeen():Boolean{
        return pref.getBoolean(SEEN_KEY,false)
    }

    fun saveScreen(){
        pref.edit().putBoolean(SEEN_KEY,true).apply()
    }

    fun saveName(name: String){
        pref.edit().putString(NAME_KEY,name).apply()
    }

    fun getName(): String{
        return pref.getString(NAME_KEY,"").toString()
    }




    companion object{
        const val PREF_NAME = "Task.pref"
        const val SEEN_KEY = "seen.key"
        const val NAME_KEY= "name.key"
    }
}
