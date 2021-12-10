package com.abusada.teachme.application.di_modules

import android.app.Application
import com.abusada.teachme.data.datastore.MyDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStore(application: Application): MyDataStore = MyDataStore(application)

}