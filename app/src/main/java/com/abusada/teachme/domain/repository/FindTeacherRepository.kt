package com.abusada.teachme.domain.repository

import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface FindTeacherRepository {

    suspend fun getCourses(shouldFetch: Boolean): Flow<Resource<List<CourseGrade>>>

    suspend fun getGrades(courseId: Int, shouldFetch: Boolean): Flow<Resource<List<Grade>>>

}