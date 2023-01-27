package com.example.hom1mon4.ui.data

import androidx.contentpager.content.Query
import com.example.hom1mon4.ui.task.TaskData

@Dao
interface TaskDao {
    @Query("SELECT * FROM user")
    fun getAll(): List <TaskData>

    @Insert
    fun insert(taskData: TaskData)

    @Delete
    fun delete(taskData: Unit)

    @Update
    fun update(taskData: TaskData)


}