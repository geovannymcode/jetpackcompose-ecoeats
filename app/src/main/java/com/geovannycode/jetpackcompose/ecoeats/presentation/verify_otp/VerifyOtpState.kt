package com.geovannycode.jetpackcompose.ecoeats.presentation.verify_otp

data class VerifyOtpState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: String? = null
)
