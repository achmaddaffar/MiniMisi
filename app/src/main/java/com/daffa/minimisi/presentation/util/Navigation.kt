package com.daffa.minimisi.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.daffa.minimisi.presentation.login.LoginScreen
import com.daffa.minimisi.presentation.onboarding.OnBoardingScreen
import com.daffa.minimisi.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.AuthNavigation.route
    ) {
        navigation(
            startDestination = Navigation.AuthNavigation.startDestination,
            route = Navigation.AuthNavigation.route
        ) {
            composable(Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(Screen.OnBoardingScreen.route) {
                OnBoardingScreen(navController = navController)
            }
            composable(Screen.RegisterScreen.route) {

            }
            composable(Screen.LoginScreen.route) {

            }
        }

        navigation(
            startDestination = Navigation.HomeNavigation.startDestination,
            route = Navigation.HomeNavigation.route
        ) {

        }
    }
}

sealed class Navigation(
    val startDestination: String,
    val route: String,
) {
    object AuthNavigation : Navigation(Screen.SplashScreen.route, "auth_navigation")
    object HomeNavigation : Navigation(Screen.HomeScreen.route, "home_navigation")
}