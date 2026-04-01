package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_up

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    val repository: AuthRepository
) : ViewModel() {

    var formState by mutableStateOf(SignUpFormState())
    var state by mutableStateOf(SignUpState())

    fun onEvent(event: SignUpFormEvent) {
        when (event) {
            is SignUpFormEvent.NumeroDocumentoChange -> {
                formState = formState.copy(numeroDocumento = event.numeroDocumento)
            }
            is SignUpFormEvent.NombresChange -> {
                formState = formState.copy(nombres = event.nombres)
            }
            is SignUpFormEvent.ApellidosChange -> {
                formState = formState.copy(apellidos = event.apellidos)
            }
            is SignUpFormEvent.CorreoChange -> {
                formState = formState.copy(correo = event.correo)
            }
            is SignUpFormEvent.PasswordChange -> {
                formState = formState.copy(password = event.password)
            }
            is SignUpFormEvent.PasswordVisualTransformationChange -> {
                formState = formState.copy(passwordVisualTransformation = event.passwordVisualTransformation)
            }
            SignUpFormEvent.Submit -> {
                register()
            }
        }
    }

    private fun register() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.register(
                        numeroDocumento = formState.numeroDocumento,
                        nombres = formState.nombres,
                        apellidos = formState.apellidos,
                        correo = formState.correo,
                        password = formState.password
                    )
                }
                when (response) {
                    is Result.Error -> {
                        state = state.copy(isLoading = false, error = response.message, success = null)
                    }
                    is Result.Success -> {
                        state = state.copy(isLoading = false, success = response.data, error = null)
                    }
                }
            } catch (ex: Exception) {
                state = state.copy(isLoading = false, error = ex.message)
            }
        }
    }
}
