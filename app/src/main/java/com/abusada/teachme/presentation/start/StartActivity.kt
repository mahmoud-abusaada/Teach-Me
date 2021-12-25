package com.abusada.teachme.presentation.start

import com.abusada.teachme.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abusada.teachme.domain.usecase.find_teacher.GetCoursesUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class StartActivity : AppCompatActivity() {

//    private val tempViewModel : FindTeacherViewModel by

    @Inject
    lateinit var getCoursesUseCase: GetCoursesUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        CoroutineScope(Dispatchers.Main).launch {
            getCoursesUseCase.execute(true)
        }
    }
}