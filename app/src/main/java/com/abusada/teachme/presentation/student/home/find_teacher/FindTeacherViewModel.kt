package com.abusada.teachme.presentation.student.home.find_teacher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abusada.teachme.data.models.Course

class FindTeacherViewModel : ViewModel() {

    val courses = MutableLiveData<ArrayList<Course>>()

    fun initCourses() {
        val coursesList = ArrayList<Course>()
        coursesList.add(Course(1, "Maths"))
        coursesList.add(Course(2, "English"))
        coursesList.add(Course(3, "Arabic"))
        coursesList.add(Course(4, "Physics"))
        courses.postValue(coursesList)
    }
}