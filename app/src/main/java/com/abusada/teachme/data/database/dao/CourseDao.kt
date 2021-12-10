package com.abusada.teachme.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.models.CourseGrade
import com.abusada.teachme.data.models.Course

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course)

}