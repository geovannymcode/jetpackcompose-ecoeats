package com.geovannycode.jetpackcompose.ecoeats.presentation.dishes

import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishDto

data class DishState(
    val isLoading:Boolean=false,
    val error:String?=null,
    var success:List<DishDto>?=null
)