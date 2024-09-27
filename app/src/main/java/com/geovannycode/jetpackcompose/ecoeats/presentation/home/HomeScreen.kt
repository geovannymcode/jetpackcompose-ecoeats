package com.geovannycode.jetpackcompose.ecoeats.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.TopBarComponent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val items = listOf(
        BottomNavigationItem(
            title = "Dishes",
            selectIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Filled.Home,
            hasNews = false,
            route = ""
        ),
        BottomNavigationItem(
            title = "Search",
            selectIcon = Icons.Filled.Search,
            unSelectedIcon = Icons.Filled.Search,
            hasNews = true,
            badgeCount = 4,
            route = ""
        ),
        BottomNavigationItem(
            title = "Settings",
            selectIcon = Icons.Filled.Settings,
            unSelectedIcon = Icons.Filled.Settings,
            hasNews = true,
            route = ""
        )
    )
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarComponent(imageVector = Icons.Filled.Menu,
                onIconClick = {

                }
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex)
                                        item.selectIcon
                                    else item.unSelectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )

                }
            }
        }
    ) { paddingValues ->

    }
}