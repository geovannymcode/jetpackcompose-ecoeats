package com.geovannycode.jetpackcompose.ecoeats.data.networking.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("message") val message:String,
    @SerializedName("data") val data: UserDto
)

data class UserDto(
    @SerializedName("id") val id:Int,
    @SerializedName("email") val email:String,
    @SerializedName("token") val token:String,
    @SerializedName("tokenFirebaseAuth") val tokenFirebaseAuth:String,
)