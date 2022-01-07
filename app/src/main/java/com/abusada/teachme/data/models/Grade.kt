package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.GRADE_TABLE)
data class Grade(
    @PrimaryKey
    val id: Int? = 0,
    val name: String? = ""
)