package com.geovannycode.jetpackcompose.ecoeats.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Primary

@Composable
fun ImageBasic(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    description: String
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun SpacerComponent(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier)
}

@Composable
fun TextBasic(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    color: Color = Color.Unspecified
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = color,
    )
}

@Composable
fun ButtonBasic(
    modifier: Modifier = Modifier,
    text: String,
    containerColor: Color = Primary,
    contentColor: Color = Color.White,
    onClick:() -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ){
        Text(
            text = text
        )
    }
}