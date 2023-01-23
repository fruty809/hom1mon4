package com.example.hom1mon4.ui.Profile

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.hom1mon4.databinding.FragmentProfileBinding
import com.example.hom1mon4.ui.data.Pref

class Profile : Fragment() {




    private val launcher = registerForActivityResult<Intent, Instrumentation.ActivityResult>(
        ActivityResultContracts.StartActivityForResult()
    ) { result: Instrumentation.ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
            val photoUri = result.data?.data
            pref.saveImage(photoUri.toString())
            binding.profileImage.loadIMage(photoUri.toString())

        }
    }


    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnProfile.setOnClickListener{

        }

    }







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.profileImage.loadIMage(pref.getImage())

        pref = Pref(requireContext())
        binding.profileEd.setText(pref.getName())
        binding.profileEd.setText(pref.getAge())



        binding.btnProfile.setOnClickListener {
            pref.saveName(binding.profileEd.text.toString())
            pref.saveAge(binding.ageId.text.toString())


        }

        binding.profileImage.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action= Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
