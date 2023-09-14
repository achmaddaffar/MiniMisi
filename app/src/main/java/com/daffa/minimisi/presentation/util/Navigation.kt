package com.daffa.minimisi.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.daffa.minimisi.presentation.login.LoginScreen
import com.daffa.minimisi.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.SplashNavigation.route
    ) {
        navigation(
            startDestination = Navigation.SplashNavigation.startDestination,
            route = Navigation.SplashNavigation.route
        ) {
            composable(Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(Screen.OnBoardingScreen.route) {
                
            }
        }

        navigation(
            startDestination = Navigation.AuthNavigation.startDestination,
            route = Navigation.AuthNavigation.route
        ) {
            composable(Screen.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
            composable(Screen.RegisterScreen.route) {

            }
        }
    }
}

private sealed class Navigation(
    val startDestination: String,
    val route: String,
) {
    object SplashNavigation : Navigation(Screen.SplashScreen.route, "splash_navigation")
    object AuthNavigation : Navigation(Screen.LoginScreen.route, "auth_navigation")
}