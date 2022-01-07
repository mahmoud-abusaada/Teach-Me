package com.abusada.teachme.domain.usecase.find_teacher

import com.abusada.teachme.data.models.Course
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.repository.FindTeacherRepository
import kotlinx.coroutines.flow.Flow

class GetCoursesUseCase(private val findTeacherRepository: FindTeacherRepository) {

    suspend fun execute(shouldFetch: Boolean): Flow<Resource<List<CourseGrade>>> =
        findTeacherRepository.getCourses(shouldFetch)

}