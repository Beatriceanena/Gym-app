package com.carolinekayle.gymit.api

import com.carolinekayle.gymit.LoginResponse
import com.carolinekayle.gymit.models.RegisterRequest
import com.carolinekayle.gymit.models.RegisterResponse
import com.carolinekayle.gymit.models.loginRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
   fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/login")
   suspend fun loginUser(@Body loginRequest:loginRequest): Response<LoginResponse>

}
