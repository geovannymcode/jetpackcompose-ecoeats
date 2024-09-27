package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

import androidx.compose.ui.text.input.PasswordVisualTransformation

data class LoginFormState(
    val email: String = "",
    val password: String = "",
    val passwordVisualTransformation: Boolean = true,
)