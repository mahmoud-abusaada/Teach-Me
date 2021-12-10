package com.abusada.teachme.application.di_modules

import com.abusada.teachme.application.AppExecutors
import com.abusada.teachme.data.api.LoginApiEndPoint
import com.abusada.teachme.data.database.dao.*
import com.abusada.teachme.data.datastore.MyDataStore
import com.abusada.teachme.data.repository.LoginRepositoryImpl
import com.abusada.teachme.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository(
        loginApiEndPoint: LoginApiEndPoint,
        appExecutors: AppExecutors,
        courseDao: CourseDao,
        courseGradeDao: CourseGradeDao,
        favoriteTeacherDao: FavoriteTeacherDao,
        gradeDescriptionDao: GradeDescriptionDao,
        userInfoDao: UserInfoDao,
        myDataStore: MyDataStore
    ): LoginRepository =
        LoginRepositoryImpl(loginApiEndPoint, appExecutors, courseDao, courseGradeDao, favoriteTeacherDao, gradeDescriptionDao, userInfoDao, myDataStore)

}