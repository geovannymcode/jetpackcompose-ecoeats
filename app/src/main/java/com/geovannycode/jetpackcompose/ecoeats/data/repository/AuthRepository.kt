package com.geovannycode.jetpackcompose.ecoeats.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.ForgotPasswordRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.RegisterRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.ResetPasswordRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.UserDto
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.VerifyOtpRequest
import com.geovannycode.jetpackcompose.ecoeats.data.util.Util.save
import javax.inject.Inject
import javax.inject.Named

class AuthRepository @Inject constructor(
    @Named("provideSharePreferencesEncrypted") val sharedPreferences: SharedPreferences
) {
    suspend fun signIn(email: String, password: String): Result<UserDto> {
        try {
            val response = Api.build().signIn(
                LoginRequest(email = email, password = password)
            )
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {
                    sharedPreferences.save(data.data.token)
                    return Result.Success(data = data.data)
                } else {
                    return Result.Error(message = data?.message.toString())
                }
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }

    suspend fun register(
        numeroDocumento: String,
        nombres: String,
        apellidos: String,
        correo: String,
        password: String
    ): Result<String> {
        try {
            val response = Api.build().register(
                RegisterRequest(
                    numeroDocumento = numeroDocumento,
                    nombres = nombres,
                    apellidos = apellidos,
                    correo = correo,
                    password = password
                )
            )
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {
                    data.data?.let { sharedPreferences.save(it.token) }
                    return Result.Success(data = data.message)
                } else {
                    return Result.Error(message = data?.message.toString())
                }
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }

    suspend fun forgotPassword(email: String): Result<String> {
        try {
            val response = Api.build().forgotPassword(
                ForgotPasswordRequest(email = email)
            )
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {
                    return Result.Success(data = data.message)
                } else {
                    return Result.Error(message = data?.message.toString())
                }
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }

    suspend fun verifyOtp(email: String, otp: String): Result<String> {
        try {
            val response = Api.build().verifyOtp(
                VerifyOtpRequest(email = email, otp = otp)
            )
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {
                    return Result.Success(data = data.message)
                } else {
                    return Result.Error(message = data?.message.toString())
                }
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }

    suspend fun resetPassword(email: String, otp: String, newPassword: String): Result<String> {
        try {
            val response = Api.build().resetPassword(
                ResetPasswordRequest(email = email, otp = otp, newPassword = newPassword)
            )
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {
                    return Result.Success(data = data.message)
                } else {
                    return Result.Error(message = data?.message.toString())
                }
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }
}