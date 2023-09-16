package com.daffa.minimisi.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.daffa.minimisi.presentation.gigDetail.GigDetailScreen
import com.daffa.minimisi.presentation.home.HomeScreen
import com.daffa.minimisi.presentation.login.LoginScreen
import com.daffa.minimisi.presentation.onboarding.OnBoardingScreen
import com.daffa.minimisi.presentation.profile.ProfileScreen
import com.daffa.minimisi.presentation.register.RegisterScreen
import com.daffa.minimisi.presentation.search.SearchScreen
import com.daffa.minimisi.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = modifier
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(Screen.HistoryScreen.route) {

        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable("${Screen.GigDetailScreen.route}/{id}") {
            GigDetailScreen(
                navController = navController,
                it.arguments?.getString("id")
            )
        }
    }
}