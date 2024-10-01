package com.geovannycode.jetpackcompose.ecoeats.data.networking

import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishResponse
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

object Api {

    // http://betolix-001-site1.etempurl.com/api/securities/login
    //URL_BASE:http://betolix-001-site1.etempurl.com/
    //METODO: /api/securities/login

    //1. Configurar Retrofit
    val retrofit = Retrofit.Builder()
        .baseUrl("http://betolix-001-site1.etempurl.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

   //2. Definir Metodos
    interface MethodsApi{
        @POST("api/securities/login")
        suspend fun signIn(@Body request: LoginRequest): Response<LoginResponse>

       @GET("api/dish")
       suspend fun getDishes(
           @Header("Authorization") token:String
       ) : Response<DishResponse>
    }



    //3. Devolver una instancia
    fun build(): MethodsApi{
        return retrofit.create(MethodsApi::class.java)
    }
}