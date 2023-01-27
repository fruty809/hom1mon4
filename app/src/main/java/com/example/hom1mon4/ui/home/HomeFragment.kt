package com.example.hom1mon4.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.hom1mon4.R
import com.example.hom1mon4.databinding.FragmentHomeBinding
import com.example.hom1mon4.ui.App
import com.example.hom1mon4.ui.task.TaskData
import com.example.hom1mon4.ui.task.Task
import com.example.hom1mon4.ui.task.TaskAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() , TaskAdapter.Listener{
    private lateinit var builder: AlertDialog.Builder
    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter

    private val binding get() = _binding!!
    private val task:Task
        get() {
            TODO()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this)
        builder = AlertDialog.Builder(requireActivity())



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tasks = App.db.taskDao().getAll()
        adapter.addTasks(tasks)
        binding.recycleTask.adapter = adapter
        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(adapter: TaskData) {
        binding.recycleTask.setOnLongClickListener {
            builder.setTitle("Delete?").setMessage("Are you Sure?").setCancelable(true).setPositiveButton("Yes") { _, _ ->
                GlobalScope.launch {
                    App.db.taskDao().delete(task.binding())
                }
            }.setNegativeButton("No"){ DialogInterface, _ -> DialogInterface.cancel()}
            return@setOnLongClickListener true
        }
        super.onClick(adapter)
    }



}