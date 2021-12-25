package com.abusada.teachme.presentation.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abusada.teachme.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
    }
}