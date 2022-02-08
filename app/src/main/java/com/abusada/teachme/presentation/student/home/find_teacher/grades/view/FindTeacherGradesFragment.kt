package com.abusada.teachme.presentation.student.home.find_teacher.grades.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherGradesBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel
import com.abusada.teachme.presentation.student.home.find_teacher.grades.model.FindTeacherGradesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherGradesFragment : BaseFragment(R.layout.fragment_find_teacher_grades) {

    private val viewModel: FindTeacherViewModel by activityViewModels()

    private val mBinding by viewBinding(FragmentFindTeacherGradesBinding::bind)

    private lateinit var adapter: FindTeacherGradesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FindTeacherGradesAdapter(viewModel)

        viewModel.grades.observe(viewLifecycleOwner, {
            adapter.mItems = it
            adapter.notifyDataSetChanged()
        })

        viewModel.findTeacherActions.observe(viewLifecycleOwner, {
            when (it) {
                is FindTeacherViewModel.FindTeacherActions.GradeClicked -> {
                    viewModel.selectedGradeId = it.grade.id!!
                    findNavController().navigate(R.id.action_findTeacherGradesFragment_to_findTeacherTeachersFragment)
                    viewModel.getCourseGradeTeachers()
                }
            }
        })

        viewModel.initGrades()

        mBinding.findTeacherGradesRecyclerView.adapter = adapter

    }

}