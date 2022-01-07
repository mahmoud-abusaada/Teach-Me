package com.abusada.teachme.presentation.student.home.find_teacher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.usecase.find_teacher.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindTeacherViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    val coursesGrades = MutableLiveData<Resource<List<CourseGrade>>>()
    val grades = MutableLiveData<ArrayList<Grade>>()
    val findTeacherActions = MutableLiveData<FindTeacherActions>()
    var selectedCourse: CourseGrade = CourseGrade()

    fun initCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            getCoursesUseCase.execute(true).collect {
                coursesGrades.postValue(it)
            }
        }
    }

    fun initGrades() {
//        val gradesList = ArrayList<Grade>()
//        gradesList.add(Grade(1, "1st Grade"))
//        gradesList.add(Grade(2, "2nd Grade"))
//        gradesList.add(Grade(3, "3rd Grade"))
//        gradesList.add(Grade(4, "4th Grade"))
        grades.postValue(selectedCourse.grades as ArrayList<Grade>?)
    }

    fun onFindTeacherAction(findTeacherActions: FindTeacherActions) {
        this.findTeacherActions.value = findTeacherActions
    }

    fun onCourseClicked(courseGrade: CourseGrade){
        findTeacherActions.value = FindTeacherActions.CourseClicked(courseGrade)
    }

    fun onGradeClicked(grade: Grade){
        findTeacherActions.value = FindTeacherActions.GradeClicked(grade)
    }

    sealed class FindTeacherActions() {
        class CourseClicked(val courseGrade: CourseGrade) : FindTeacherActions()
        class GradeClicked(val grade: Grade) : FindTeacherActions()
    }

    enum class FindTeacherActionsEnums {
        CourseClicked
    }
}