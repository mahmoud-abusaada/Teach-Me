package com.abusada.teachme.presentation.start.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentAccountTypeBinding

class AccountTypeFragment : Fragment() {

    lateinit var binding: FragmentAccountTypeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAccountTypeBinding.inflate(inflater, container, false)

        binding.studentTypeButton.setOnClickListener {
            findNavController().navigate(R.id.action_accountTypeFragment_to_signUpStudentPersonalInfoFragment)
        }

        binding.teacherTypeButton.setOnClickListener {
            findNavController().navigate(R.id.action_accountTypeFragment_to_signUpTeacherPersonalInfoFragment)
        }

        binding.alreadyHaveAccountButton.setOnClickListener {
            findNavController().navigate(R.id.action_accountTypeFragment_to_loginFragment)
        }

        return binding.root
    }

}