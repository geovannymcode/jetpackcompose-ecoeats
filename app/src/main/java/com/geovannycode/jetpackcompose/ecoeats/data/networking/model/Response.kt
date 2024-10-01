package com.geovannycode.jetpackcompose.ecoeats.data.networking.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("success") val success:Boolean,
    @SerializedName("message") val message:String,
    @SerializedName("data") val data: UserDto
)

data class UserDto(
    @SerializedName("id") val id:Int,
    @SerializedName("email") val email:String,
    @SerializedName("token") val token:String,
    @SerializedName("tokenFirebaseAuth") val tokenFirebaseAuth:String,
)

data class DishResponse(
    @SerializedName("message")  val message: String,
    @SerializedName("success") val success: Boolean,
    @SerializedName("data") val data: List<DishDto>,
)
data class DishDto(
    val carbohydrates: Int,
    val description: String,
    val flagHeader: Boolean,
    val id: Int,
    val image: String,
    val ingredients: String,
    val name: String,
    val price: Int,
    val proteins: Int,
    val rating: Double,
    val thumbails: String
) : Serializable