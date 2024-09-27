package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

sealed class LoginFormEvent {
    data class EmailChange(val email: String) : LoginFormEvent()
    data class PasswordChange(val password: String) : LoginFormEvent()
    data class PasswordVisualTransformationChange(val passwordVisualTransformation: Boolean): LoginFormEvent()
    object Submit: LoginFormEvent()
}