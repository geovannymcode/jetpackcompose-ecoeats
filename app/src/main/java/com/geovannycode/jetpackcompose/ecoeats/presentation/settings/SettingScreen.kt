package com.geovannycode.jetpackcompose.ecoeats.presentation.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingScreen(modifier: Modifier = Modifier,paddingValues: PaddingValues) {
    Text(text = "Settings",modifier = Modifier.padding(paddingValues))
}