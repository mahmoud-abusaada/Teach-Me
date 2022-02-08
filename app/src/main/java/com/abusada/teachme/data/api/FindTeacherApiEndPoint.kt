package com.abusada.teachme.data.api

import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.domain.common.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FindTeacherApiEndPoint {

    @GET("courses")
    fun getCourses(): Flow<Resource<List<CourseGrade>>>

    @GET("grades")
    fun getGrades(@Query("courseId") courseId: Int): Flow<Resource<List<Grade>>>

    @GET("teachers")
    fun getCourseGradeTeachers(
        @Query("course_id") courseId: Int,
        @Query("grade_id") gradeId: Int
    ): Flow<Resource<List<Teacher>>>

    @GET("favoriteTeachers/{studentId}")
    fun getFavoriteTeachers(@Path("studentId") studentId: Long): Flow<Resource<List<Teacher>>>

}