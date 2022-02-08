package com.abusada.teachme.presentation.student.teacher_info.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.abusada.teachme.R
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.databinding.FragmentTeacherInfoBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding

class TeacherInfoFragment : BaseFragment(R.layout.fragment_teacher_info) {

    private val mBinding by viewBinding(FragmentTeacherInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(mBinding.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        mBinding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressed() }
    }
}