package com.abusada.teachme.application.di_modules

import com.abusada.teachme.domain.repository.FindTeacherRepository
import com.abusada.teachme.domain.repository.LoginRepository
import com.abusada.teachme.domain.usecase.LoginUseCase
import com.abusada.teachme.domain.usecase.find_teacher.GetCoursesUseCase
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
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase =
        LoginUseCase(loginRepository)

    @Singleton
    @Provides
    fun provideGetCoursesUseCase(findTeacherRepository: FindTeacherRepository): GetCoursesUseCase =
        GetCoursesUseCase(findTeacherRepository)

}