package com.geovannycode.jetpackcompose.ecoeats.data.repository

import android.content.Context
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.UserDto

class AuthRepository {
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
                if(data?.success == true){
                    data?.data?.token
                   /* val preferences = getSharedPreferences("PREFERENCES_TOKEN", 0).edit()
                    preferences.putString("KEY_TOKEN", data?.data?.token)
                    preferences.apply()*/
                    return Result.Success(data = data?.data)
                }else{
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