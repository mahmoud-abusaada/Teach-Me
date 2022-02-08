package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.COURSE_TABLE)
open class Course(
    @PrimaryKey
    var id: Int? = 0,
    var name: String? = ""
)