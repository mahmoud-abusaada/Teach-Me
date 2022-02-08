package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.FAVORITE_TEACHER_TABLE)
data class FavoriteTeacher(
    @PrimaryKey
    val userId: Long? = -1
)