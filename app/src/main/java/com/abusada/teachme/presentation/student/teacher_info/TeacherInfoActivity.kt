package com.abusada.teachme.presentation.student.teacher_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abusada.teachme.R
import com.abusada.teachme.databinding.FragmentFindTeacherTeachersBinding
import com.abusada.teachme.presentation.common.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeacherInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_info)
    }
}