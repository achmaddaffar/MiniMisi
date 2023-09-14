package com.daffa.minimisi.presentation.util

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object OnBoardingScreen: Screen("on_boarding_screen")
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}