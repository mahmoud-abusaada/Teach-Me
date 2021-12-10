package com.abusada.teachme.data.models

import androidx.room.Entity
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.TEACHER_TABLE)
data class Teacher(
    var title: String,
    var information: String,
    var hourPrice: Float,
    var rate: Float
) : UserInfo() {
    constructor() : this("", "", 0.0f, 0.0f)
}