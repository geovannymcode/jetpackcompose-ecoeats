package com.geovannycode.jetpackcompose.ecoeats.presentation.reset_password

data class ResetPasswordState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: String? = null
)
