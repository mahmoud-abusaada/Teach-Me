package com.abusada.teachme.data.repository

import com.abusada.teachme.data.api.FindTeacherApiEndPoint
import com.abusada.teachme.data.database.dao.CourseDao
import com.abusada.teachme.data.database.dao.GradeDao
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.common.networkBoundResource
import com.abusada.teachme.domain.repository.FindTeacherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class FindTeacherRepositoryImpl(
    private val findTeacherApiEndPoint: FindTeacherApiEndPoint,
    private val coursesDao: CourseDao,
    private val gradesDao: GradeDao
) : FindTeacherRepository {

    override suspend fun getCourses(shouldFetch: Boolean): Flow<Resource<List<CourseGrade>>> =
        networkBoundResource(
            fetch = { findTeacherApiEndPoint.getCourses() },
            saveFetchResult = { items ->
                items.collect { coursesResource ->
                    coursesResource.data?.let {
                        for(courseGrade : CourseGrade in it) {
                            courseGrade.course?.let { it1 -> coursesDao.insertCourse(it1) }
                            courseGrade.grades?.let { it1 -> gradesDao.insertGrades(it1) }
                        }
                    }
                }
            },
            query = {
                coursesDao.getCourseGrades()
            },
            shouldFetch = { shouldFetch }
        )

    override suspend fun getGrades(courseId: Int, shouldFetch: Boolean): Flow<Resource<List<Grade>>> = networkBoundResource(
        fetch = { findTeacherApiEndPoint.getGrades(courseId) },
        saveFetchResult = { items ->
            items.collect { gradesResource ->
                gradesResource.data?.let {
                    gradesDao.insertGrades(it)
                }
            }
        },
        query = {
//            gradesDao.getGrades(courseId)
                return@networkBoundResource flow {

                }
        },
        shouldFetch = { shouldFetch }
    )

}