package com.carolinekayle.gymit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolinekayle.gymit.LoginResponse
import com.carolinekayle.gymit.Repository.UserRepository
import com.carolinekayle.gymit.models.RegisterRequest
import com.carolinekayle.gymit.models.RegisterResponse
import com.carolinekayle.gymit.models.loginRequest
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository = UserRepository()
    val loginResponseLiveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()

    fun loginUser(loginRequest: loginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginResponseLiveData.postValue(response.body())

            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}


