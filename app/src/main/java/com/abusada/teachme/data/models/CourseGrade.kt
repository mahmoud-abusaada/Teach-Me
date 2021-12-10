package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.COURSE_GRADE_TABLE)
data class CourseGrade(
    @PrimaryKey
    val course_id: Int,
    val grade_id: String
){
    constructor() : this(-1, "")
}