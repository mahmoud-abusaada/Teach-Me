package com.abusada.teachme.presentation.student.home.find_teacher.courses.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherCoursesBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel
import com.abusada.teachme.presentation.student.home.find_teacher.courses.model.FindTeacherCoursesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherCoursesFragment : BaseFragment(R.layout.fragment_find_teacher_courses) {

    private val viewModel: FindTeacherViewModel by activityViewModels()

    private val mBinding by viewBinding(FragmentFindTeacherCoursesBinding::bind)

    private lateinit var adapter: FindTeacherCoursesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FindTeacherCoursesAdapter(viewModel)

        viewModel.coursesGrades.observe(viewLifecycleOwner, { coursesResource ->
            coursesResource.data?.let {
                adapter.mItems = ArrayList(it)
                adapter.notifyDataSetChanged()
            }
        })

        viewModel.findTeacherActions.observe(viewLifecycleOwner, {
            when (it) {
                is FindTeacherViewModel.FindTeacherActions.CourseClicked -> {
                    viewModel.selectedCourse = it.courseGrade
                    viewModel.selectedCourseId = it.courseGrade.id!!
                    findNavController().navigate(R.id.action_findTeacherCoursesFragment_to_findTeacherGradesFragment)
                }
            }
        })

        viewModel.initCourses()

        mBinding.findTeacherCoursesRecyclerView.adapter = adapter

    }

}