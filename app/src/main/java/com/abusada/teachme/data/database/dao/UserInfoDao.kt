package com.abusada.teachme.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.models.UserInfo

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userInfo: UserInfo)

    @Query("SELECT * FROM user_table")
    fun getUserInfo(): LiveData<UserInfo>

}