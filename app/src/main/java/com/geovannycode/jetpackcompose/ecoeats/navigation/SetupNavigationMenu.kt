package com.geovannycode.jetpackcompose.ecoeats.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishDto
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.detail.DetailScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.dishes.DishesScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.search.SearchScreen
import com.geovannycode.jetpackcompose.ecoeats.presentation.settings.SettingScreen
import com.google.gson.Gson

@Composable
fun SetupNavigationMenu(
    navController: NavHostController,
    paddingValues: PaddingValues,
    onChangeVisibleBottomBar:(Boolean)->Unit
) {

    NavHost(
        navController = navController,
        startDestination = ScreenMenu.Dishes.route
    ){
        composable(route = ScreenMenu.Dishes.route){
            DishesScreen(
                paddingValues = paddingValues,
                onClick = {
                    val dishJson = Gson().toJson(it)
                    navController.navigate(ScreenMenu.Detail.createRoute(dishJson))
                }
            )
        }
        composable(route = ScreenMenu.Search.route){
            SearchScreen(paddingValues = paddingValues)
        }
        composable(route = ScreenMenu.Settings.route){
            SettingScreen(paddingValues = paddingValues)
        }
        composable(route = ScreenMenu.Detail.route){
            val dishJson = it.arguments?.getString("dishJson")
            val dishDto = Gson().fromJson(dishJson, DishDto::class.java)
            requireNotNull(dishDto)
            DetailScreen(dishDto = dishDto)
        }
    }
}