package com.geovannycode.jetpackcompose.ecoeats.navigation

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen(route = "onboarding_screen")
    object SignInScreen : Screen(route = "sign_in_screen")
    object SignUpScreen : Screen(route = "sign_up_screen")
    object ForgotPasswordScreen : Screen(route = "forgot_password_screen")
    object VerifyOtpScreen : Screen(route = "verify_otp_screen/?email={email}") {
        fun createRoute(email: String) = "verify_otp_screen/?email=$email"
    }
    object ResetPasswordScreen : Screen(route = "reset_password_screen/?email={email}&otp={otp}") {
        fun createRoute(email: String, otp: String) = "reset_password_screen/?email=$email&otp=$otp"
    }
    object WelcomeScreen : Screen(route = "welcome_screen")
    object HomeScreen : Screen(route = "home_screen")
}