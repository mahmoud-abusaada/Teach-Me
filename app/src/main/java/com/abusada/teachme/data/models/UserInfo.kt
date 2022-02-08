package com.abusada.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abusada.teachme.application.AppConstants
import com.abusada.teachme.data.database.MyDatabase
import com.google.gson.annotations.SerializedName

@Entity(tableName = MyDatabase.TABLES.USER_INFO_TABLE)
open class UserInfo(
    @PrimaryKey
    @SerializedName("id")
    var userId: Long? = -1,
    var username: String? = "",
    @SerializedName("country_id")
    var countryId: Int? = -1,
    var email: String? = "",
    @SerializedName("first_name")
    var firstName: String? = "",
    @SerializedName("last_name")
    var lastName: String? = "",
    var location_lat: Double? = 0.0,
    var location_lng: Double? = 0.0,
    @SerializedName("account_type")
    var accountType: Int? = AppConstants.AccountType.STUDENT.value,
    @SerializedName("phone_number")
    var phoneNumber: String? = "",
    var token: String? = ""
)