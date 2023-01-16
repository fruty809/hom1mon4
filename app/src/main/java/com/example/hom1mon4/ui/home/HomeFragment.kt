package com.example.hom1mon4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hom1mon4.R
import com.example.hom1mon4.databinding.FragmentHomeBinding
import com.example.hom1mon4.ui.TaskData
import com.example.hom1mon4.ui.task.Task

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
            setFragmentResultListener(Task.RESULT_TASK) { key, bundle -> val result =bundle.getSerializable("bundleKey") as TaskData }

        }
    }







    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}