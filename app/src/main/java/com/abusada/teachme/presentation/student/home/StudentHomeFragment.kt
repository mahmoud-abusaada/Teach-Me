package com.abusada.teachme.presentation.student.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentStudentHomeBinding
import com.abusada.teachme.presentation.BaseFragment
import com.abusada.teachme.presentation.common.viewBinding

class StudentHomeFragment : BaseFragment(R.layout.fragment_student_home) {

    private val mBinding by viewBinding(FragmentStudentHomeBinding::bind)
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNavController()

    }

    private fun setupNavController() {
        if (!::navController.isInitialized) {
            val navHostFragment =
                childFragmentManager.findFragmentById(R.id.studentHomeFragmentContainer) as NavHostFragment
            navController = navHostFragment.navController
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.studentBottomNavFindTeacherFragment -> {
                    changeToolbarTitle(getString(R.string.find_teacher))
                }
                R.id.studentBottomNavLessonsFragment -> {
                    changeToolbarTitle(getString(R.string.lessons))
                }
                R.id.studentBottomNavMessagesFragment -> {
                    changeToolbarTitle(getString(R.string.messages))
                }
                R.id.studentBottomNavNotificationsFragment -> {
                    changeToolbarTitle(getString(R.string.notifications))
                }
            }
        }

        mBinding.studentHomeBottomNavigation.setupWithNavController(navController)
    }

    private fun changeToolbarTitle(title: String) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }

}