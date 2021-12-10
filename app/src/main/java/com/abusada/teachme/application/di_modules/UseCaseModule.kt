package com.abusada.teachme.application.di_modules

import com.abusada.teachme.domain.repository.LoginRepository
import com.abusada.teachme.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesLoginUseCase(loginRepository: LoginRepository): LoginUseCase =
        LoginUseCase(loginRepository)

}