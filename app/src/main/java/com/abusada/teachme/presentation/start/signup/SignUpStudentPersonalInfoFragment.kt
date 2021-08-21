package com.abusada.teachme.presentation.start.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentSignUpStudentPersonalInfoBinding

class SignUpStudentPersonalInfoFragment : Fragment() {

    lateinit var binding: FragmentSignUpStudentPersonalInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpStudentPersonalInfoBinding.inflate(inflater, container, false)

        binding.studentPersonalNextButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpStudentPersonalInfoFragment_to_signUpUserCredentialInfoFragment)
        }

        return binding.root
    }

}