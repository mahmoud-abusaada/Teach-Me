package com.abusada.teachme.application

object AppConstants {

    // Database
    const val APP_DATABASE_NAME = "teach_me"

    const val BASE_URL = "http://192.168.10.10/"

    enum class AccountType(val value: Int) {
        STUDENT(0),
        TEACHER(1);

        companion object {
            fun fromInt(value: Int) = values().first { it.value == value }
        }
    }

}