package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.data.database.MyDatabase
import com.google.gson.annotations.SerializedName

@Entity(tableName = MyDatabase.TABLES.USER_INFO_TABLE)
open class UserInfo(

    @PrimaryKey
    @SerializedName("id")
    var userId: Int,

    var username: String,

    @SerializedName("country_id")
    var countryId: Int,

    var email: String,

    @SerializedName("first_name")
    var firstName: String,

    @SerializedName("last_name")
    var lastName: String,

    var location_lat: Double,

    var location_lng: Double,

    @SerializedName("account_type")
    var accountType: Int,

    @SerializedName("phone_number")
    var phoneNumber: String,

    var token: String

){
    constructor() : this(-1,"",-1,"","","",0.0, 0.0,1,"","")
}