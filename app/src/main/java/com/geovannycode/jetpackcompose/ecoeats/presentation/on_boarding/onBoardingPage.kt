package com.geovannycode.jetpackcompose.ecoeats.presentation.on_boarding

import androidx.annotation.DrawableRes
import com.geovannycode.jetpackcompose.ecoeats.R

data class OnBoardingPage(
    @DrawableRes val image:Int,
    val title: String,
    val description: String
)

fun getDataOnBoarding(): List<OnBoardingPage> {
    return listOf(
        OnBoardingPage(
            image = R.drawable.image1,
            title = "Greetings",
            description = "Lorem Ipsum is simply dummy text of the\n" +
                    "printing."
        ),
        OnBoardingPage(
            image = R.drawable.image2,
            title = "Explore",
            description = "Lorem Ipsum is simply dummy text of the\n" +
                    "printing and typesetting industry."
        ),
        OnBoardingPage(
            image = R.drawable.image3,
            title = "Power",
            description = "Lorem Ipsum is simply dummy text of the\n" +
                    "printing and typesetting industry Ipsum is simple."
        )
    )

}