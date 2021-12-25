package com.abusada.teachme.presentation.student.home.find_teacher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.data.models.GradeDescription
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

    val courses = MutableLiveData<Resource<List<Course>>>()
    val grades = MutableLiveData<ArrayList<GradeDescription>>()
    val findTeacherActions = MutableLiveData<FindTeacherActions>()

    fun initCourses() {
//        val coursesList = ArrayList<Course>()
//        coursesList.add(Course(1, "Maths"))
//        coursesList.add(Course(2, "English"))
//        coursesList.add(Course(3, "Arabic"))
//        coursesList.add(Course(4, "Physics"))
//        courses.postValue(coursesList)
        viewModelScope.launch(Dispatchers.IO) {
            getCoursesUseCase.execute(false).collect {
                courses.postValue(it)
            }
        }
    }

    fun initGrades() {
        val gradesList = ArrayList<GradeDescription>()
        gradesList.add(GradeDescription(1, "1st Grade"))
        gradesList.add(GradeDescription(2, "2nd Grade"))
        gradesList.add(GradeDescription(3, "3rd Grade"))
        gradesList.add(GradeDescription(4, "4th Grade"))
        grades.postValue(gradesList)
    }

    fun onFindTeacherAction(findTeacherActions: FindTeacherActions) {
        this.findTeacherActions.value = findTeacherActions
    }

    fun onCourseClicked(course: Course){
        findTeacherActions.value = FindTeacherActions.CourseClicked(course)
    }

    sealed class FindTeacherActions {
        class CourseClicked(val course: Course) : FindTeacherActions()
    }

    enum class FindTeacherActionsEnums {
        CourseClicked
    }
}