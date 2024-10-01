package com.geovannycode.jetpackcompose.ecoeats.presentation.common.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishDto

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    dishDto: DishDto
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = dishDto.name)
    }
}