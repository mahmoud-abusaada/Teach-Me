package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.GRADE_DESCRIPTION_TABLE)
data class GradeDescription(
    @PrimaryKey
    val grade_english: Int,
    val grade_id: String
){
    constructor() : this(-1, "")
}