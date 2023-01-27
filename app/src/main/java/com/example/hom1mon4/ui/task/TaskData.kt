package com.example.hom1mon4.ui.task

import java.io.Serializable

@Entity
data  class TaskData (
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var title:String? = null,
    var desc:String? = null

) : Serializable
