package com.geovannycode.jetpackcompose.ecoeats.presentation.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Text(text = "Search",modifier = Modifier.padding(paddingValues))
}