package com.abusada.teachme.presentation.start.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abusada.teachme.databinding.FragmentSignUpUserCredentialInfoBinding

class SignUpUserCredentialInfoFragment : Fragment() {

    lateinit var binding: FragmentSignUpUserCredentialInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpUserCredentialInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

}