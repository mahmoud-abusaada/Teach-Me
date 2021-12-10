package com.abusada.teachme.application.di_modules

import com.abusada.teachme.data.api.LoginApiEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EndPointModule {

    @Singleton
    @Provides
    fun provideLoginApiEndPoint(retrofit: Retrofit): LoginApiEndPoint =
        retrofit.create(LoginApiEndPoint::class.java)

}