package com.abusada.teachme.data.api

import com.abusada.teachme.data.models.UserInfo
import com.abusada.teachme.domain.common.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApiEndPoint {

    @GET("users/1")
    fun login(
        @Query("user") username: String,
        @Query("pass") password: String,
        @Query("token") token: String
    ): Flow<Resource<ResponseBody>>

}