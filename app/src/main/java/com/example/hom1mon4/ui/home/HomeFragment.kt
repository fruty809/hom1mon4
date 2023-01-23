package com.example.hom1mon4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.hom1mon4.R
import com.example.hom1mon4.databinding.FragmentHomeBinding
import com.example.hom1mon4.ui.task.TaskData
import com.example.hom1mon4.ui.task.Task
import com.example.hom1mon4.ui.task.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
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

        setFragmentResultListener(Task.RESULT_TASK) { _, bundle -> val result =bundle.getSerializable("bundleKey") as TaskData
            adapter.addTask(result)
        }


        binding.recycleTask.adapter = adapter
        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.task)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
