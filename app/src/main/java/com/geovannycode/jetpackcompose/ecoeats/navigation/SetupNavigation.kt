package com.geovannycode.jetpackcompose.ecoeats.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.geovannycode.jetpackcompose.ecoeats.presentation.home.HomeScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.on_boarding.OnBoardingScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.sign_in.SingInScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.welcome.WelcomeScreen

@Composable
fun SetupNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.OnBoardingScreen.route)
                }
            )
        }
        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardingScreen()
            {
                navController.popBackStack()
                navController.navigate(Screen.SignInScreen.route)
            }
        }
        composable(route = Screen.SignInScreen.route) {
            SingInScreen(
                onNavigationHome = {
                    navController.popBackStack()
                    navController.navigate(Screen.HomeScreen.route)
                }
            )
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen()
        }
    }

}