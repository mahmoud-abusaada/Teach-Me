package com.abusada.teachme.data.repository

import com.abusada.teachme.data.api.FindTeacherApiEndPoint
import com.abusada.teachme.data.database.dao.CourseDao
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.common.networkBoundResource
import com.abusada.teachme.domain.repository.FindTeacherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class FindTeacherRepositoryImpl(
    private val findTeacherApiEndPoint: FindTeacherApiEndPoint,
    private val coursesDao: CourseDao
) : FindTeacherRepository {

    override suspend fun getCourses(shouldFetch: Boolean): Flow<Resource<List<Course>>> =
        networkBoundResource(
            fetch = { findTeacherApiEndPoint.getCourses() },
            saveFetchResult = { items ->
                items.collect { coursesResource ->
                    coursesResource.data?.let {
                        coursesDao.insertCourses(it)
                    }
                }
            },
            query = {
                coursesDao.getCourses()
            },
            shouldFetch = { shouldFetch }
        )

//    override suspend fun getGrades(courseId: Int): Flow<Resource<List<GradeDescription>>> = networkBoundResource(
//        fetch = { findTeacherApiEndPoint.getGrades(courseId) }
//    )

}