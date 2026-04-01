package com.geovannycode.jetpackcompose.ecoeats.presentation.reset_password

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
class ResetPasswordViewModel @Inject constructor(
    val repository: AuthRepository
) : ViewModel() {

    var newPassword by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var passwordVisualTransformation by mutableStateOf(true)
    var state by mutableStateOf(ResetPasswordState())

    fun resetPassword(email: String, otp: String) {
        if (newPassword != confirmPassword) {
            state = state.copy(error = "Las contraseñas no coinciden")
            return
        }
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.resetPassword(email, otp, newPassword)
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
