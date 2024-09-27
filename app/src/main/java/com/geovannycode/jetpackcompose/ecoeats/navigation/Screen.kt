package com.geovannycode.jetpackcompose.ecoeats.navigation

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen(route = "onboarding_screen")
    object SignInScreen : Screen(route = "sign_in_screen")
    object WelcomeScreen : Screen(route = "welcome_screen")
    object HomeScreen : Screen(route = "home_screen")
}