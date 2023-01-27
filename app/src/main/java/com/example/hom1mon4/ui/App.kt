package com.example.hom1mon4.ui

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class App: Application() {


    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"database-name").allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDatabase

    }
}