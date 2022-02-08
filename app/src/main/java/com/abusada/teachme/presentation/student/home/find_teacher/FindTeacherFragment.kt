package com.abusada.teachme.presentation.student.home.find_teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.BaseViewPagerAdapter
import com.abusada.teachme.presentation.common.viewBinding
import com.abusada.teachme.presentation.student.home.find_teacher.course_grade.view.FindTeacherCourseGradeFragment
import com.abusada.teachme.presentation.student.home.find_teacher.favorites.view.FindTeacherFavoriteTeachersFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FindTeacherFragment : BaseFragment(R.layout.fragment_find_teacher) {

    private val viewModel: FindTeacherViewModel by activityViewModels()

    private val mBinding by viewBinding(FragmentFindTeacherBinding::bind)

    private lateinit var adapter: BaseViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BaseViewPagerAdapter(childFragmentManager, lifecycle)

        adapter.addFragment(FindTeacherCourseGradeFragment(), "Courses")
        adapter.addFragment(FindTeacherFavoriteTeachersFragment(), "Favorites")
        adapter.notifyDataSetChanged()

        mBinding.findTeacherViewPager.adapter = adapter

        TabLayoutMediator(mBinding.findTeacherTabLayout, mBinding.findTeacherViewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
            mBinding.findTeacherViewPager.setCurrentItem(tab.position, true)
        }.attach()

    }

}