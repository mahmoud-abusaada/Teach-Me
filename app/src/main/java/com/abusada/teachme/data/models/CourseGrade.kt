package com.abusada.teachme.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.abusada.teachme.data.database.MyDatabase

data class CourseGrade(
    @Embedded
    val course: Course? = Course(),
    @Relation(parentColumn = "id", entityColumn = "id")
    val grades: List<Grade>? = ArrayList()
)