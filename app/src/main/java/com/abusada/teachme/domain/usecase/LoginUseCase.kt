package com.abusada.teachme.domain.usecase

import com.abusada.teachme.data.models.UserInfo
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(private val loginRepository: LoginRepository) {

    suspend fun execute(username: String, password: String): Flow<Resource<UserInfo>> =
        loginRepository.login(username, password)

}