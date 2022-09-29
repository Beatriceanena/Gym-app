package com.carolinekayle.gymit.Repository

import com.carolinekayle.gymit.LoginResponse
import com.carolinekayle.gymit.api.ApiInterface
import com.carolinekayle.gymit.api.apiclient
import com.carolinekayle.gymit.models.loginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=apiclient.ApiClient.buildApiClient((ApiInterface::class.java))
suspend fun loginUser(loginRequest: loginRequest):Response<LoginResponse>
= withContext(Dispatchers.IO){
 val  response = apiClient.loginUser(loginRequest)
 return@withContext response

  }

}