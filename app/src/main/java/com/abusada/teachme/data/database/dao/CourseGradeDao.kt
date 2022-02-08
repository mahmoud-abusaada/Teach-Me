package com.abusada.teachme.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.models.CourseGrade
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseGradeDao {

    @Transaction @Query("SELECT * FROM course_table")
    fun getCourseGrades(): Flow<List<CourseGrade>>

}