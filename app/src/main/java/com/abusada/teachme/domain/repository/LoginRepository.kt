package com.abusada.teachme.domain.repository

import com.abusada.teachme.data.models.UserInfo
import com.abusada.teachme.domain.common.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun login(username: String, password: String): Flow<Resource<UserInfo>>

}