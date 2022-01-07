package com.abusada.teachme.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.models.Grade

@Dao
interface GradeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGrade(grade: Grade)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGrades(grade: List<Grade>)

}