package com.abusada.teachme.data.repository

import com.abusada.teachme.application.AppConstants
import com.abusada.teachme.application.AppExecutors
import com.abusada.teachme.data.api.LoginApiEndPoint
import com.abusada.teachme.data.database.dao.*
import com.abusada.teachme.data.datastore.MyDataStore
import com.abusada.teachme.data.models.UserInfo
import com.abusada.teachme.data.models.type_adapters.UserTypeAdapter
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.extensions.networkBoundResource
import com.abusada.teachme.domain.repository.LoginRepository
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class LoginRepositoryImpl(
    private val loginApiEndPoint: LoginApiEndPoint,
    private val appExecutors: AppExecutors,
    private val courseDao: CourseDao,
    private val courseGradeDao: CourseGradeDao,
    private val favoriteTeacherDao: FavoriteTeacherDao,
    private val gradeDao: GradeDao,
    private val userInfoDao: UserInfoDao,
    private val myDataStore: MyDataStore
) : LoginRepository {

    override suspend fun login(
        username: String,
        password: String
    ): Flow<Resource<UserInfo>> = networkBoundResource(
        query = {
            when (myDataStore.accountType) {
                AppConstants.AccountType.STUDENT -> return@networkBoundResource myDataStore.studentInfo
                AppConstants.AccountType.TEACHER -> return@networkBoundResource myDataStore.teacherInfo
            }
        },
        fetch = { loginApiEndPoint.login(username, password, "") },
        saveFetchResult = { items ->
            items.collect {
                it.data?.let { it1 ->
                    val gson =
                        GsonBuilder().registerTypeAdapter(UserInfo::class.java, UserTypeAdapter())
                            .create()
                    val userInfo = gson.fromJson(it1.string(), UserInfo::class.java)
                    myDataStore.saveUserInfo(userInfo)
                }
            }
        }
    )

//    @ExperimentalCoroutinesApi
//    @FlowPreview
//    override suspend fun login(
//        username: String,
//        password: String
//    ): Flow<Resource<LoginResponse>> =
//        object :
//            NetworkBoundResource<LoginResponse, LoginResponse>() {
//
//            override fun shouldFetch(data: LoginResponse?) = true
//
//            override fun loadFromDb() = flow {
//                emit(LoginResponse(userInfo = userInfoDao.getUserInfo().value ?: UserInfo()))
//            }
//
//            override suspend fun saveNetworkResult(item: LoginResponse) {
//                userInfoDao.insertUserInfo(item.userInfo)
//            }
//
//            override suspend fun fetchFromNetwork() = loginApiEndPoint.login(username, password, "")
//
//        }.asFlow()

}
