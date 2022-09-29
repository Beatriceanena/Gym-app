package com.carolinekayle.gymit.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("phone_number")var PhoneNumber: String,
    @SerializedName("first_name")var firstName: String,
    @SerializedName("last_name")var lastName: String,
    @SerializedName("UserId")var userId: String,
    @SerializedName("email")var email: String,


    )
