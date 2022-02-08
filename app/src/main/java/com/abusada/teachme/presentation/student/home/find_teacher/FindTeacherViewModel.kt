package com.abusada.teachme.presentation.student.home.find_teacher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.usecase.find_teacher.GetCourseGradeTeachersUseCase
import com.abusada.teachme.domain.usecase.find_teacher.GetCoursesUseCase
import com.abusada.teachme.domain.usecase.find_teacher.GetFavoriteTeachersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FindTeacherViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val getCourseGradeTeachersUseCase: GetCourseGradeTeachersUseCase,
    private val favoriteTeachersUseCase: GetFavoriteTeachersUseCase
) : ViewModel() {

    val coursesGrades = MutableLiveData<Resource<List<CourseGrade>>>()
    val coursesGradeTeachers = MutableLiveData<Resource<List<Teacher>>>()
    val favoriteTeachers = MutableLiveData<Resource<List<Teacher>>>()
    val grades = MutableLiveData<ArrayList<Grade>>()
    val findTeacherActions = MutableLiveData<FindTeacherActions>()
    var selectedCourse: CourseGrade = CourseGrade()
    var selectedCourseId = -1
    var selectedGradeId = -1

    fun initCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            getCoursesUseCase.execute(true).collect {
                coursesGrades.postValue(it)
            }
        }
    }

    fun initGrades() {
        grades.postValue(selectedCourse.grades as ArrayList<Grade>?)
    }

    fun getCourseGradeTeachers(){
        viewModelScope.launch(Dispatchers.IO) {
            getCourseGradeTeachersUseCase.execute(selectedCourseId, selectedGradeId).collect {
                coursesGradeTeachers.postValue(it)
            }
        }
    }

    fun getFavoriteTeachers(studentId: Long){
        viewModelScope.launch(Dispatchers.IO) {
            favoriteTeachersUseCase.execute(studentId).collect {
                favoriteTeachers.postValue(it)
            }
        }
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

    fun onTeacherClicked(teacher: Teacher){
        findTeacherActions.value = FindTeacherActions.TeacherClicked(teacher)
    }

    sealed class FindTeacherActions() {
        class CourseClicked(val courseGrade: CourseGrade) : FindTeacherActions()
        class GradeClicked(val grade: Grade) : FindTeacherActions()
        class TeacherClicked(val teacher: Teacher) : FindTeacherActions()
    }

    enum class FindTeacherActionsEnums {
        CourseClicked
    }
}