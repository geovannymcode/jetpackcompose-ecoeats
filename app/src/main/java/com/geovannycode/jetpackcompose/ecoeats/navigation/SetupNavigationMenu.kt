package com.geovannycode.jetpackcompose.ecoeats.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.geovannycode.jetpackcompose.ecoeats.presentation.dishes.DishesScreen

@Composable
fun SetupNavigationMenu(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = ScreenMenu.Dishes.route
    ) {
        composable(route = ScreenMenu.Dishes.route) {
            DishesScreen()
        }
        composable(route = ScreenMenu.Search.route) {
            DishesScreen()
        }
        composable(route = ScreenMenu.Settings.route) {
            DishesScreen()
        }
        composable(route = ScreenMenu.Detail.route) {
            DishesScreen()
        }

    }

}