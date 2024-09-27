package com.geovannycode.jetpackcompose.ecoeats.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.UserDto
import com.geovannycode.jetpackcompose.ecoeats.data.util.Util.save
import javax.inject.Inject
import javax.inject.Named

class AuthRepository @Inject constructor(
    @Named("provideSharePreferencesEncrypted") val sharedPreferences: SharedPreferences
) {
    suspend fun signIn(email: String, password: String): Result<UserDto> {
        try {
            val response = Api.build().signIn(
                LoginRequest(
                    email = email,
                    password = password
                )
            )
            if (response.isSuccessful) {
                val data = response.body()
                if (data?.success == true) {
                    sharedPreferences.save(data.data?.token ?: "")
                    return Result.Success(data = data?.data)
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