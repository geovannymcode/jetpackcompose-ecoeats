package com.geovannycode.jetpackcompose.ecoeats.presentation.verify_otp

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
class VerifyOtpViewModel @Inject constructor(
    val repository: AuthRepository
) : ViewModel() {

    var otp by mutableStateOf("")
    var state by mutableStateOf(VerifyOtpState())

    fun verifyOtp(email: String) {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.verifyOtp(email, otp)
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
