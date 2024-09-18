package com.geovannycode.jetpackcompose.ecoeats.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.geovannycode.jetpackcompose.ecoeats.R
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ButtonBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ImageBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.SpacerComponent
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.TextBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.previews.PreviewDefault
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Secundary

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            contentAlignment = Alignment.Center
            ) {
            WelcomeHeader()
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            contentAlignment = Alignment.BottomCenter
            ) {
            WelcomeContent(
                onClick = {
                    onClick()
                }
            )

        }
    }
}

@Composable
fun WelcomeContent(onClick: () -> Unit) {

    ImageBasic(
        image = R.drawable.background_fruits,
        description = "Background Fruits",
        modifier = Modifier.fillMaxSize()
    )

    ButtonBasic(
        text = "Empezar",
        modifier = Modifier.padding(bottom = 16.dp),
        onClick = {
            onClick()
        }
    )
    
}

@Composable
fun WelcomeHeader() {
    Column {
    ImageBasic(
        image = R.drawable.ecoeats_logo,
        description = "EcoEats",
        modifier = Modifier
            .fillMaxWidth()
            .size(20.dp)
    )
    SpacerComponent(modifier = Modifier.padding(top = 8.dp))

    TextBasic(
        text = "A healthy life",
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Secundary
        ),
        modifier = Modifier
            .fillMaxWidth()
      )
    }
}

@PreviewDefault
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onClick = {})
}