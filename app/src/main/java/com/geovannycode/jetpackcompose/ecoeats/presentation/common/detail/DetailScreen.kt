package com.geovannycode.jetpackcompose.ecoeats.presentation.common.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.geovannycode.jetpackcompose.ecoeats.data.networking.model.DishDto
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.RatingBarComponent
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.SpacerComponent
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.TextBasic
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Secundary

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    dishDto: DishDto
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(dishDto.image)
                .crossfade(500)
                .build(),
            contentDescription = dishDto.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            TextBasic(
                text = dishDto.name,
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            RatingBarComponent(currentRating = dishDto.rating.toInt())
            SpacerComponent(modifier = Modifier.height(12.dp))
            TextBasic(
                text = dishDto.description,
                style = TextStyle(fontSize = 16.sp)
            )
            SpacerComponent(modifier = Modifier.height(16.dp))
            TextBasic(
                text = "Precio",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            SpacerComponent(modifier = Modifier.height(4.dp))
            TextBasic(
                text = "$${dishDto.price}",
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Secundary)
            )
            SpacerComponent(modifier = Modifier.height(16.dp))
            TextBasic(
                text = "Información Nutricional",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(containerColor = Secundary.copy(alpha = 0.1f))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        TextBasic(
                            text = "Carbohidratos",
                            style = TextStyle(fontSize = 12.sp)
                        )
                        TextBasic(
                            text = "${dishDto.carbohydrates}g",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Secundary)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Card(
                    modifier = Modifier.weight(1f),
                    colors = CardDefaults.cardColors(containerColor = Secundary.copy(alpha = 0.1f))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        TextBasic(
                            text = "Proteínas",
                            style = TextStyle(fontSize = 12.sp)
                        )
                        TextBasic(
                            text = "${dishDto.proteins}g",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Secundary)
                        )
                    }
                }
            }
            SpacerComponent(modifier = Modifier.height(16.dp))
            TextBasic(
                text = "Ingredientes",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            SpacerComponent(modifier = Modifier.height(8.dp))
            TextBasic(
                text = dishDto.ingredients,
                style = TextStyle(fontSize = 14.sp)
            )
            SpacerComponent(modifier = Modifier.height(24.dp))
        }
    }
}