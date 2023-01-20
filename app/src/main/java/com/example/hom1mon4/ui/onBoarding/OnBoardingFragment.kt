package com.example.hom1mon4.ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hom1mon4.databinding.FragmentOnBoardingBinding
import com.example.hom1mon4.ui.onBoarding.BoardingAdapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.pager
        val adapter1 = OnBoardingAdapter(){
            findNavController().navigateUp()
        }
        viewPager.adapter = adapter1
        dotsIndicator.attachTo(viewPager)




        viewPager.adapter = adapter1

        binding.pager.adapter = adapter1


    }




}