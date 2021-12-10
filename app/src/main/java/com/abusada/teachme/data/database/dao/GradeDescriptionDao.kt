package com.abusada.teachme.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.abusada.teachme.data.models.GradeDescription

@Dao
interface GradeDescriptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGradeDescription(gradeDescription: GradeDescription)

}