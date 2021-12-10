package com.abusada.teachme.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.abusada.teachme.application.AppConstants
import com.abusada.teachme.data.models.Student
import com.abusada.teachme.data.models.Teacher
import com.abusada.teachme.data.models.UserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class MyDataStore(val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "main_data")

    suspend fun saveUserInfo(userInfo: UserInfo) {
        context.dataStore.edit { preferences ->

            preferences[USER_ID] = userInfo.userId
            preferences[FIRST_NAME] = userInfo.firstName
            preferences[LAST_NAME] = userInfo.lastName
            preferences[USERNAME] = userInfo.username
            preferences[EMAIL] = userInfo.email
            preferences[PHONE_NUMBER] = userInfo.phoneNumber
            preferences[COUNTRY_ID] = userInfo.countryId
            preferences[LOCATION_LAT] = userInfo.location_lat
            preferences[LOCATION_LNG] = userInfo.location_lng
            preferences[ACCESS_TOKEN] = userInfo.token
            preferences[ACCOUNT_TYPE] = userInfo.accountType

            when (userInfo) {
                is Student -> {
                    preferences[AGE] = userInfo.age
                }
                is Teacher -> {
                    preferences[TITLE] = userInfo.title
                    preferences[INFORMATION] = userInfo.information
                    preferences[HOUR_PRICE] = userInfo.hourPrice
                    preferences[RATE] = userInfo.rate
                }
            }
        }
    }

    val accountType: AppConstants.AccountType =
        AppConstants.AccountType.fromInt(runBlocking { context.dataStore.data.first() }[ACCOUNT_TYPE] ?: 0)

    val studentInfo: Flow<Student> = context.dataStore.data
        .map { preferences ->

            val student = Student()

            student.userId = preferences[USER_ID] ?: 0
            student.firstName = preferences[FIRST_NAME] ?: ""
            student.lastName = preferences[LAST_NAME] ?: ""
            student.username = preferences[USERNAME] ?: ""
            student.email = preferences[EMAIL] ?: ""
            student.phoneNumber = preferences[PHONE_NUMBER] ?: ""
            student.countryId = preferences[COUNTRY_ID] ?: -1
            student.location_lat = preferences[LOCATION_LAT] ?: 0.0
            student.location_lng = preferences[LOCATION_LNG] ?: 0.0
            student.token = preferences[ACCESS_TOKEN] ?: ""
            student.accountType =
                preferences[ACCOUNT_TYPE] ?: AppConstants.AccountType.STUDENT.value

            student.age = preferences[AGE] ?: 0

            student
        }

    val teacherInfo: Flow<Teacher> = context.dataStore.data
        .map { preferences ->

            val teacher = Teacher()

            teacher.userId = preferences[USER_ID] ?: 0
            teacher.firstName = preferences[FIRST_NAME] ?: ""
            teacher.lastName = preferences[LAST_NAME] ?: ""
            teacher.username = preferences[USERNAME] ?: ""
            teacher.email = preferences[EMAIL] ?: ""
            teacher.phoneNumber = preferences[PHONE_NUMBER] ?: ""
            teacher.countryId = preferences[COUNTRY_ID] ?: -1
            teacher.location_lat = preferences[LOCATION_LAT] ?: 0.0
            teacher.location_lng = preferences[LOCATION_LNG] ?: 0.0
            teacher.token = preferences[ACCESS_TOKEN] ?: ""
            teacher.accountType =
                preferences[ACCOUNT_TYPE] ?: AppConstants.AccountType.STUDENT.value

            teacher.title = preferences[TITLE] ?: ""
            teacher.information = preferences[INFORMATION] ?: ""
            teacher.hourPrice = preferences[HOUR_PRICE] ?: 0.0f
            teacher.rate = preferences[RATE] ?: 0.0f

            teacher
        }

    companion object {
        private val USER_ID = intPreferencesKey("user_id")
        private val FIRST_NAME = stringPreferencesKey("first_name")
        private val LAST_NAME = stringPreferencesKey("last_name")
        private val USERNAME = stringPreferencesKey("username")
        private val EMAIL = stringPreferencesKey("email")
        private val PHONE_NUMBER = stringPreferencesKey("phone_number")
        private val COUNTRY_ID = intPreferencesKey("country_id")
        private val LOCATION_LAT = doublePreferencesKey("location_lat")
        private val LOCATION_LNG = doublePreferencesKey("location_lng")
        private val ACCESS_TOKEN = stringPreferencesKey("token")
        private val ACCOUNT_TYPE = intPreferencesKey("account_type")
        private val AGE = intPreferencesKey("age")
        private val TITLE = stringPreferencesKey("title")
        private val INFORMATION = stringPreferencesKey("information")
        private val HOUR_PRICE = floatPreferencesKey("hour_price")
        private val RATE = floatPreferencesKey("rate")
    }

}