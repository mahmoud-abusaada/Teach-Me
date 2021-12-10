package com.abusada.teachme.application.di_modules

import android.app.Application
import androidx.room.Room
import com.abusada.teachme.application.AppConstants
import com.abusada.teachme.data.database.MyDatabase
import com.abusada.teachme.data.database.dao.*
import com.abusada.teachme.data.models.CourseGrade
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(application: Application): MyDatabase =
        Room.databaseBuilder(application, MyDatabase::class.java, AppConstants.APP_DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideUserInfoDao(myDatabase: MyDatabase): UserInfoDao = myDatabase.userInfoDao()

    @Singleton
    @Provides
    fun provideLoginResponseDao(myDatabase: MyDatabase): LoginResponseDao = myDatabase.loginResponseDao()

    @Singleton
    @Provides
    fun provideCourseDao(myDatabase: MyDatabase): CourseDao = myDatabase.courseDao()

    @Singleton
    @Provides
    fun provideCourseGradeDao(myDatabase: MyDatabase): CourseGradeDao = myDatabase.courseGradeDao()

    @Singleton
    @Provides
    fun provideFavoriteTeacherDao(myDatabase: MyDatabase): FavoriteTeacherDao = myDatabase.favoriteTeacherDao()

    @Singleton
    @Provides
    fun provideGradeDescriptionDao(myDatabase: MyDatabase): GradeDescriptionDao = myDatabase.gradeDescriptionDao()

}