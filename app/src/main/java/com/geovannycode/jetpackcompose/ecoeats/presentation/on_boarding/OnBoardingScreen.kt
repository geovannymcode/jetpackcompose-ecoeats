package com.geovannycode.jetpackcompose.ecoeats.presentation.on_boarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import com.google.accompanist.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geovannycode.jetpackcompose.ecoeats.R
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ButtonBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.ImageBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.common.TextBasic
import com.geovannycode.jetpackcompose.ecoeats.presentation.previews.PreviewDefault
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.DisableDot
import com.geovannycode.jetpackcompose.ecoeats.ui.theme.Primary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    val pagerState = rememberPagerState()
    val onBoardingList = getDataOnBoarding()

    Column(modifier = modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            count = onBoardingList.size,
            state = pagerState
        ) { page ->
            onBoardingContent(onBoardingPage = onBoardingList[page])
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            onBoardingFooter(pagerState = pagerState)
        }
        FinishButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pagerState = pagerState,
            pages = onBoardingList,
            onClick = {
                onClick()
            }
            //.padding(16.dp)
        )
    }
}

@Composable
fun onBoardingContent(
    modifier: Modifier = Modifier,
    onBoardingPage: OnBoardingPage
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageBasic(
            image = onBoardingPage.image,
            description = onBoardingPage.description,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
        )
        TextBasic(
            text = onBoardingPage.title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Primary
            )
        )
        TextBasic(
            text = onBoardingPage.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
                .padding(24.dp),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun onBoardingFooter(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        repeat(3) { iteration ->
            val color = if (pagerState.currentPage == iteration) Primary else DisableDot
            Box(
                modifier = modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(12.dp)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(iteration)
                        }
                    }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pages: List<OnBoardingPage>,
    onClick:()->Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visible = pagerState.currentPage == pages.size - 1,
        ) {
            ButtonBasic(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Finish",
                onClick = {
                    onClick()
                }
            )
        }
    }
}

@PreviewDefault
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(onClick = {})
}
