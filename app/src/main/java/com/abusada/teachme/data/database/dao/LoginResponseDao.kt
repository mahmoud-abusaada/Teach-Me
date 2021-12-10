package com.abusada.teachme.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.models.LoginResponse
import com.abusada.teachme.data.models.UserInfo

@Dao
interface LoginResponseDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertLoginResponse(loginResponse: LoginResponse)
//
//    @Query("SELECT * FROM " + MyDatabase.TABLES.LOGIN_RESPONSE_TABLE)
//    fun getLoginResponse(): LiveData<LoginResponse>

}