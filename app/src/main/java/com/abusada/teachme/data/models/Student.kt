package com.abusada.teachme.data.models

import androidx.room.Entity
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.STUDENT_TABLE)
data class Student(
    var age: Int
) : UserInfo() {
    constructor() : this(0)
}