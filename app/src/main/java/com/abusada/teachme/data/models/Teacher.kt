package com.abusada.teachme.data.models

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.abusada.teachme.R
import com.abusada.teachme.data.database.MyDatabase
import com.google.gson.annotations.SerializedName

@Entity(tableName = MyDatabase.TABLES.TEACHER_TABLE)
data class Teacher(
    var title: String? = "",
    var information: String? = "",
    @SerializedName("hour_price")
    var hourPrice: Float? = 0f,
    var rate: Float? = 1f
) : UserInfo(), Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Float::class.java.classLoader) as? Float
    ) {
    }

    fun getTeacherFullName(withTitle: Boolean): String {
        return (if(withTitle) "$title " else "") + firstName + " " + lastName
    }

    fun getHourPriceText(context: Context): String {
        return String.format(context.getString(R.string.hour_price), hourPrice)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(information)
        parcel.writeValue(hourPrice)
        parcel.writeValue(rate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Teacher> {
        override fun createFromParcel(parcel: Parcel): Teacher {
            return Teacher(parcel)
        }

        override fun newArray(size: Int): Array<Teacher?> {
            return arrayOfNulls(size)
        }
    }

}