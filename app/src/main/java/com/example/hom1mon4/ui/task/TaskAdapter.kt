package com.example.hom1mon4.ui.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hom1mon4.databinding.TaskModelBinding

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val data = arrayListOf<TaskData>()

    fun addTask(task: TaskData){
        data.add(0,task)
        notifyItemChanged(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(TaskModelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
    inner class TaskViewHolder(private val binding: TaskModelBinding ): RecyclerView.ViewHolder(binding.root){
        fun bind(task: TaskData) {
            binding.descText.text = task.desc
            binding.taskText.text = task.title
        }

    }

}
