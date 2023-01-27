package com.example.hom1mon4.ui.data

import androidx.room.Database
import com.example.hom1mon4.ui.task.TaskData

@Database(entities = [TaskData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}