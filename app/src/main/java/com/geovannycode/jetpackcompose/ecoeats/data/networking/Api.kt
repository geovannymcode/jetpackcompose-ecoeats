package com.geovannycode.jetpackcompose.ecoeats.data.networking

import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishResponse
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.ForgotPasswordRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginResponse
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.RegisterRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.RegisterResponse
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.ResetPasswordRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.SimpleResponse
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.SingleDishResponse
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.VerifyOtpRequest
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

object Api {

    //URL_BASE: https://delightful-contentment-production-b7bb.up.railway.app/
    //METODO: /api/securities/login

    //1. Configurar Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("https://delightful-contentment-production-b7bb.up.railway.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

   //2. Definir Metodos
    interface MethodsApi{
        @POST("api/securities/login")
        suspend fun signIn(@Body request: LoginRequest): Response<LoginResponse>

        @POST("api/securities/register")
        suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

        @POST("api/securities/forgot-password")
        suspend fun forgotPassword(@Body request: ForgotPasswordRequest): Response<SimpleResponse>

        @POST("api/securities/verify-otp")
        suspend fun verifyOtp(@Body request: VerifyOtpRequest): Response<SimpleResponse>

        @POST("api/securities/reset-password")
        suspend fun resetPassword(@Body request: ResetPasswordRequest): Response<SimpleResponse>

       @GET("api/dish")
       suspend fun getDishes(
           @Header("Authorization") token:String
       ) : Response<DishResponse>

       @GET("api/dish/{id}")
       suspend fun getDishById(
           @Header("Authorization") token:String,
           @Path("id") id: String
       ) : Response<SingleDishResponse>
    }



    //3. Devolver una instancia
    fun build(): MethodsApi{
        return retrofit.create(MethodsApi::class.java)
    }
}