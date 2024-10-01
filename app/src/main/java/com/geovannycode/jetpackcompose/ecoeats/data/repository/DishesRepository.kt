package com.geovannycode.jetpackcompose.ecoeats.data.repository

import android.content.SharedPreferences
import com.geovannycode.jetpackcompose.ecoeats.core.Result
import com.geovannycode.jetpackcompose.ecoeats.data.networking.Api
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishDto
import com.geovannycode.jetpackcompose.ecoeats.data.util.Util.getToken
import javax.inject.Inject
import javax.inject.Named

class DishesRepository @Inject constructor(
    @Named("provideSharePreferencesEncrypted") val sharedPreferences: SharedPreferences
) {
    suspend fun getDishes(): Result<List<DishDto>> {
        try {
            val token = sharedPreferences.getToken()
            val response = Api.build().getDishes("Bearer $token")
            if (response.isSuccessful) {
                return Result.Success(data = response.body()?.data)
            } else {
                return Result.Error(message = response.message())
            }
        } catch (ex: Exception) {
            return Result.Error(message = ex.message.toString())
        }
    }
}