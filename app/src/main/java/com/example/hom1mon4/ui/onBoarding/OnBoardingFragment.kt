package com.example.hom1mon4.ui.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hom1mon4.databinding.FragmentOnBoardingBinding
import com.example.hom1mon4.ui.data.Pref
import com.example.hom1mon4.ui.onBoarding.BoardingAdapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding:FragmentOnBoardingBinding
    private lateinit var pref: Pref



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        val adapter1 = OnBoardingAdapter(){
            pref.userSeen()
            findNavController().navigateUp()

        }

        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.pager

        viewPager.adapter = adapter1
        dotsIndicator.attachTo(viewPager)




        viewPager.adapter = adapter1

        binding.pager.adapter = adapter1


    }




}