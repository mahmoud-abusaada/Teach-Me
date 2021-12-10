package com.abusada.teachme.presentation.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abusada.teachme.data.datastore.MyDataStore
import com.abusada.teachme.data.models.UserInfo
import com.abusada.teachme.domain.common.Resource
import com.abusada.teachme.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    val myDataStore: MyDataStore
) : ViewModel() {

    val loginData: MutableLiveData<Resource<UserInfo>> = MutableLiveData()

    val userInfo = myDataStore.studentInfo

    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.execute(username, password).collect {
                loginData.postValue(it)
            }
        }
    }

}