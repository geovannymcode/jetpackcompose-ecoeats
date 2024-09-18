package com.geovannycode.jetpackcompose.ecoeats.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.geovannycode.jetpackcompose.ecoeats.presentation.on_boarding.OnBoardingScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.welcome.WelcomeScreen

@Composable
fun SetupNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome_screen"//Screen.OnBoardingScreen.route
    ) {
        composable(route = "welcome_screen") {
            WelcomeScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate("onboarding_screen")
                }
            )
        }
        composable(route = "onboarding_screen") {
            OnBoardingScreen()
        }
    }

}