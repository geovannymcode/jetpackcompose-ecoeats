package com.geovannycode.jetpackcompose.ecoeats.data.networking.model

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val email: String,
    val password: String
)

data class RegisterRequest(
    @SerializedName("numero_documento") val numeroDocumento: String,
    val nombres: String,
    val apellidos: String,
    val correo: String,
    val password: String
)

data class ForgotPasswordRequest(
    val email: String
)

data class VerifyOtpRequest(
    val email: String,
    val otp: String
)

data class ResetPasswordRequest(
    val email: String,
    val otp: String,
    val newPassword: String
)