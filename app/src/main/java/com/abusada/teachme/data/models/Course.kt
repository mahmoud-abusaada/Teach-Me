package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.COURSE_TABLE)
data class Course(
    @PrimaryKey
    val course_id: Int,
    val course_title: String
){
    constructor() : this(-1, "")
}