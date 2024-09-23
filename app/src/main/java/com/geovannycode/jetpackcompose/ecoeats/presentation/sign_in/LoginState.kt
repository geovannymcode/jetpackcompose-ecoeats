package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.UserDto

data class LoginState(
    val isLoading: Boolean = false,
    val error:String? = null,
    val success: UserDto?=null
)