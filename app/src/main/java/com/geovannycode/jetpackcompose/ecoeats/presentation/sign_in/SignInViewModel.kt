package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel : ViewModel() {


    //Estados Componentes
    var fromState by mutableStateOf(LoginFormState())

    //Estados de la pantalla
    var state by mutableStateOf(LoginState())

    //Eventos
    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChange -> {
                fromState = fromState.copy(email = event.email)
            }

            is LoginFormEvent.PasswordChange -> {
                fromState = fromState.copy(password = event.password)
            }

            is LoginFormEvent.PasswordVisualTransformationChange -> {
                fromState =
                    fromState.copy(passwordVisualTransformation = event.passwordVisualTransformation)
            }

            LoginFormEvent.Submit -> {
                signIn()
            }
        }
    }


    fun signIn() {
        val repository = AuthRepository()
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.signIn(fromState.email, fromState.password)
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
                state = state.copy(isLoading = false)
            }
        }
    }
}