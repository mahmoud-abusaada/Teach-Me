package com.abusada.teachme.data.repository

import androidx.lifecycle.MutableLiveData
import com.abusada.teachme.data.api.FindTeacherApiEndPoint
import com.abusada.teachme.data.database.dao.CourseDao
import com.abusada.teachme.data.database.dao.GradeDao
import com.abusada.teachme.data.database.dao.TeacherDao
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.FavoriteTeacher
import com.abusada.teachme.data.models.Grade
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.common.networkBoundResource
import com.abusada.teachme.domain.repository.FindTeacherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow

class FindTeacherRepositoryImpl(
    private val findTeacherApiEndPoint: FindTeacherApiEndPoint,
    private val coursesDao: CourseDao,
    private val gradesDao: GradeDao,
    private val teacherDao: TeacherDao
) : FindTeacherRepository {

    override suspend fun getCourses(shouldFetch: Boolean): Flow<Resource<List<CourseGrade>>> =
        networkBoundResource(
            fetch = { findTeacherApiEndPoint.getCourses() },
            saveFetchResult = { items ->
                items.collect { coursesResource ->
                    coursesResource.data?.let {
                        for(courseGrade : CourseGrade in it) {
                            courseGrade.let { it1 -> coursesDao.insertCourse(it1) }
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

    override suspend fun getCourseGradeTeachers(
        courseId: Int,
        gradeId: Int
    ): Flow<Resource<List<Teacher>>> = networkBoundResource(
        fetch = { findTeacherApiEndPoint.getCourseGradeTeachers(courseId, gradeId) },
        saveFetchResult = { items ->
            items.collect { teachersResource ->
                teachersResource.data?.let {
                    teacherDao.insertTeachers(it)
                }
            }
        },
        query = { teacherDao.getTeachers() }
    )

    override suspend fun getFavoriteTeachers(studentId: Long): Flow<Resource<List<Teacher>>> = networkBoundResource(
        fetch = { findTeacherApiEndPoint.getFavoriteTeachers(studentId) },
        saveFetchResult = { items ->
            items.collect { teachersResource ->
                teachersResource.data?.let {
                    for(teacher: Teacher in it){
                        teacherDao.insertTeacher(teacher)
                        teacherDao.insertFavoriteTeacher(FavoriteTeacher(teacher.userId))
                    }
                }
            }
        },
        query = { teacherDao.getFavoriteTeachers() }
    )

}