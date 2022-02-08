package com.abusada.teachme.presentation.student.home.find_teacher.favorites.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherFavoriteTeachersBinding
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.FindTeacherViewModel
import com.abusada.teachme.presentation.student.home.find_teacher.teachers.model.FindTeacherTeachersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherFavoriteTeachersFragment :
    BaseFragment(R.layout.fragment_find_teacher_favorite_teachers) {

    private val viewModel: FindTeacherViewModel by activityViewModels()

    private val mBinding by viewBinding(FragmentFindTeacherFavoriteTeachersBinding::bind)

    private lateinit var adapter: FindTeacherTeachersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FindTeacherTeachersAdapter(viewModel)

        viewModel.favoriteTeachers.observe(viewLifecycleOwner, { teachersResource ->
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

        viewModel.getFavoriteTeachers(1)

        mBinding.findTeacherFavoriteTeachersRecycler.adapter = adapter

    }

}