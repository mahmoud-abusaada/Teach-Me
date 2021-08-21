package com.abusada.teachme.presentation.start.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentSignUpTeacherPersonalInfoBinding

class SignUpTeacherPersonalInfoFragment : Fragment() {

    lateinit var binding: FragmentSignUpTeacherPersonalInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpTeacherPersonalInfoBinding.inflate(inflater, container, false)

        binding.teacherPersonalNextButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpTeacherPersonalInfoFragment_to_signUpUserCredentialInfoFragment)
        }

        return binding.root
    }

}