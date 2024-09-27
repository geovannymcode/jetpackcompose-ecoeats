package com.geovannycode.jetpackcompose.ecoeats.presentation.home

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title:String,
    val selectIcon:ImageVector,
    val unSelectedIcon:ImageVector,
    val route:String,
    val hasNews:Boolean,
    val badgeCount:Int? = null
)
