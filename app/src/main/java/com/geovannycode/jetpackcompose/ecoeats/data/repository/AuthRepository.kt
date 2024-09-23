package com.geovannycode.jetpackcompose.ecoeats.data.repository

import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.UserDto

class AuthRepository {
    suspend fun signIn(email: String, password: String): Result<UserDto> {
        try {
            val response = Api.build().signIn(
                LoginRequest(
                    email = "geovanny0401@gmail.com",
                    password = "123"
                )
            )
            if (response.isSuccessful) {
                val data = response.body()
                return Result.Success(data = data?.data)
            } else {
                return Result.Error(message = response.message().toString())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }
}