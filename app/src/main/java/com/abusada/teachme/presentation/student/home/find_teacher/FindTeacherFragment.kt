package com.abusada.teachme.presentation.student.home.find_teacher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherFragment : BaseFragment(R.layout.fragment_find_teacher) {

    private val viewModel: FindTeacherViewModel by viewModels()

    private val mBinding by viewBinding(FragmentFindTeacherBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}