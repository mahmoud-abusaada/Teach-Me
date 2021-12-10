package com.abusada.teachme.presentation.start.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.data.models.Student
import com.abusada.teachme.databinding.FragmentLoginBinding
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.usecase.LoginUseCase
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.extensions.clicks
import com.abusada.teachme.presentation.start.StartViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private val mBinding by viewBinding(FragmentLoginBinding::bind)

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private val viewModel: StartViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_accountTypeFragment)
        }

//        mBinding.loginButton.setOnClickListener {
//            viewModel.login("Mahmoud", "123456")
////            findNavController().navigate(R.id.action_loginFragment_to_main_nav_graph)
//        }

        viewModel.loginData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    Log.i("MyTag", "Success :: " + it.data)
                    it.data?.let { it1 ->
//                        CoroutineScope(Dispatchers.IO).launch {
//                            viewModel.myDataStore.saveUserInfo(UserInfo(userInfo = 10))
//                        }
                        findNavController().navigate(R.id.action_loginFragment_to_studentActivity2)
                    }
                }
                is Resource.Error -> Log.i("MyTag", "Error :: " + it.message)
            }
        })

        CoroutineScope(Dispatchers.Main).launch {
            launch {
                mBinding.loginButton.clicks().collect {
                    viewModel.login("Mahmoud", "123456")
                }
            }

            launch {
                viewModel.userInfo.collect {
                    Toast.makeText(requireContext(), "userId = ${it.firstName}", Toast.LENGTH_LONG).show()
                    mBinding.emailEditText.setText("id = ${it.firstName}")
                }
            }
        }
    }

}