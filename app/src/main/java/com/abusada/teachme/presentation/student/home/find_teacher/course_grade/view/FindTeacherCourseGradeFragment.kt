package com.abusada.teachme.presentation.student.home.find_teacher.course_grade.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherCourseGradeBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel

class FindTeacherCourseGradeFragment : BaseFragment(R.layout.fragment_find_teacher_course_grade) {

    private val viewModel: FindTeacherViewModel by activityViewModels()

    private val mBinding by viewBinding(FragmentFindTeacherCourseGradeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}