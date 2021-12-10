package com.abusada.teachme.presentation.student.home.find_teacher.courses.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherCoursesBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel
import com.abusada.teachme.presentation.student.home.find_teacher.courses.model.FindTeacherCoursesAdapter

class FindTeacherCoursesFragment : BaseFragment(R.layout.fragment_find_teacher_courses) {

    private val viewModel: FindTeacherViewModel by viewModels()

    private val mBinding by viewBinding(FragmentFindTeacherCoursesBinding::bind)

    private val adapter = FindTeacherCoursesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.courses.observe(viewLifecycleOwner, Observer {
            adapter.mItems = it
            adapter.notifyDataSetChanged()
        })

        viewModel.initCourses()

        mBinding.findTeacherCoursesRecyclerView.adapter = adapter

    }

}