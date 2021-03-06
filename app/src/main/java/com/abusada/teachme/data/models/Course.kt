package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.COURSE_TABLE)
data class Course(
    @PrimaryKey
    val id: Int? = 0,
    val name: String? = ""
)