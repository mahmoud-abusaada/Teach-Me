package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase

@Entity(tableName = MyDatabase.TABLES.FAVORITE_TEACHER_TABLE)
data class FavoriteTeacher(
    @PrimaryKey
    val user_id: Int,
    val first_name: String,
    val hour_price: String,
    val information: String,
    val last_name: String,
    val location_lat: String,
    val location_lng: String,
    val rate: String,
    val title: String
){
    constructor() : this(-1,"","","","","","","", "")
}