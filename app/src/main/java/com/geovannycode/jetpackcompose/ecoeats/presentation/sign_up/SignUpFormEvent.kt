package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_up

sealed class SignUpFormEvent {
    data class NumeroDocumentoChange(val numeroDocumento: String) : SignUpFormEvent()
    data class NombresChange(val nombres: String) : SignUpFormEvent()
    data class ApellidosChange(val apellidos: String) : SignUpFormEvent()
    data class CorreoChange(val correo: String) : SignUpFormEvent()
    data class PasswordChange(val password: String) : SignUpFormEvent()
    data class PasswordVisualTransformationChange(val passwordVisualTransformation: Boolean) : SignUpFormEvent()
    object Submit : SignUpFormEvent()
}
