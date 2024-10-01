package com.geovannycode.jetpackcompose.ecoeats.navigation

sealed class ScreenMenu(val route: String) {
    object Dishes : ScreenMenu("dishes_screen")
    object Search : ScreenMenu("search_screen")
    object Settings : ScreenMenu("setting_screen")
    object Detail : ScreenMenu(route = "detail_screen/?dishJson={dishJson}"){
        fun createRoute(dishJson:String) = "detail_screen/?dishJson=$dishJson"
    }
}