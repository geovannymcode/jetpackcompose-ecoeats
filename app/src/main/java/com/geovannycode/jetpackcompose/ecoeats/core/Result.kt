package com.geovannycode.jetpackcompose.ecoeats.core

import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.UserDto

sealed class Result<T>(val data:T?=null, val message:String?=null) {

    class Success<T>(data: T?) :Result<T>(data)
    class Error<T>(message:String): Result<T>(message = message)
    //class Loading<T>: Result<T>()
}