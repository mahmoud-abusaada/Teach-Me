package com.abusada.teachme.data.api

import retrofit2.http.Field
import retrofit2.http.GET

interface LoginApiEndPoint {

    @GET("/login.php")
    fun login(@Field("user") username: String, @Field("pass") password: String, @Field("token") token: String)

}