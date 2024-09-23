package com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel : ViewModel() {

    //Eventos
    //Estados Componentes

    //Estados de la pantalla

    var state by mutableStateOf(LoginState())

    val repository = AuthRepository()

    fun signIn(email: String, password: String) {

        state = state.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.signIn(email, password)
                }

                when (response) {
                    is Result.Error -> {
                        state = state.copy(isLoading = false, error = response.message)
                    }

                    is Result.Success -> {
                        state = state.copy(isLoading = false, success = response.data)
                    }
                }
            } catch (ex: Exception) {
                state = state.copy(isLoading = false)
            }
        }
    }
}