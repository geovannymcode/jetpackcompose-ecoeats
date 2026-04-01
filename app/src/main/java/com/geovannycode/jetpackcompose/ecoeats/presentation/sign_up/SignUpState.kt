package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_up

data class SignUpState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: String? = null
)
