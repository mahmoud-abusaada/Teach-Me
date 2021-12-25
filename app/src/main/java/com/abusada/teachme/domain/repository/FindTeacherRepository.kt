package com.abusada.teachme.domain.repository

import com.abusada.teachme.data.models.Course
import com.abusada.teachme.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface FindTeacherRepository {

    suspend fun getCourses(shouldFetch: Boolean): Flow<Resource<List<Course>>>

//    suspend fun getGrades(courseId: Int): Flow<Resource<List<GradeDescription>>>

}