package com.geovannycode.jetpackcompose.ecoeats.navigation

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen()
    object SignInScreen : Screen()
    object WelcomeScreen : Screen()
}