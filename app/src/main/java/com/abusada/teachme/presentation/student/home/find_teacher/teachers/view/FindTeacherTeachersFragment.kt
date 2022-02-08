package com.abusada.teachme.presentation.student.home.find_teacher.teachers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherTeachersBinding
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel
import com.abusada.teachme.presentation.student.home.find_teacher.teachers.model.FindTeacherTeachersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherTeachersFragment : BaseFragment(R.layout.fragment_find_teacher_teachers) {

    private val viewModel: FindTeacherViewModel by activityViewModels()

    private val mBinding by viewBinding(FragmentFindTeacherTeachersBinding::bind)

    private lateinit var adapter: FindTeacherTeachersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FindTeacherTeachersAdapter(viewModel)

        viewModel.coursesGradeTeachers.observe(viewLifecycleOwner, { teachersResource ->
            when (teachersResource) {
                is Resource.Error -> {
                    Toast.makeText(context, teachersResource.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    teachersResource.data?.let {
                        adapter.mItems = ArrayList(it)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        })

        viewModel.findTeacherActions.observe(viewLifecycleOwner, {
            when(it){
                is FindTeacherViewModel.FindTeacherActions.TeacherClicked -> {
                    Navigation.findNavController(requireActivity(), R.id.studentMainFragmentContainer).navigate(R.id.action_studentHomeFragment2_to_teacherInfoActivity)
                }
            }
        })

        mBinding.teachersRecyclerView.adapter = adapter
    }

}