package com.abusada.teachme.data.api

import com.abusada.teachme.data.models.Course
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.domain.common.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface FindTeacherApiEndPoint {

    @GET("courses")
    fun getCourses(): Flow<Resource<List<CourseGrade>>>

    @GET("grades")
    fun getGrades(@Query("courseId") courseId: Int): Flow<Resource<List<Grade>>>

}