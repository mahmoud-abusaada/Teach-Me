package com.abusada.teachme.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.models.Course
import com.abusada.teachme.data.models.CourseGrade
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourses(courses: List<Course>)

    @Query("SELECT * FROM " + MyDatabase.TABLES.COURSE_TABLE)
    fun getCourseGrades(): Flow<List<CourseGrade>>

}