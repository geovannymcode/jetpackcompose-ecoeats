package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_up

data class SignUpFormState(
    val numeroDocumento: String = "",
    val nombres: String = "",
    val apellidos: String = "",
    val correo: String = "",
    val password: String = "",
    val passwordVisualTransformation: Boolean = true
)
