package com.abusada.teachme.presentation.student.home.find_teacher.grades.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherGradesBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.BaseRecyclerViewAdapter
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel
import com.abusada.teachme.presentation.student.home.find_teacher.grades.model.FindTeacherGradesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherGradesFragment : BaseFragment(R.layout.fragment_find_teacher_grades) {

    private val viewModel: FindTeacherViewModel by viewModels()

    private val mBinding by viewBinding(FragmentFindTeacherGradesBinding::bind)

    private val adapter = FindTeacherGradesAdapter(object : BaseRecyclerViewAdapter.RecyclerViewListener{

        override fun onItemClicked(position: Int) {

        }

    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.grades.observe(viewLifecycleOwner, {
            adapter.mItems = it
            adapter.notifyDataSetChanged()
        })

        viewModel.initGrades()

        mBinding.findTeacherGradesRecyclerView.adapter = adapter

    }

}