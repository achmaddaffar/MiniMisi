package com.daffa.minimisi.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.util.Screen

class MiniMisiNavigationActions(private val navController: NavController) {

    fun navigateTo(destination: MiniMisiTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.id) {
                saveState = true
                inclusive = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATION = listOf(
    MiniMisiTopLevelDestination(
        route = Screen.HomeScreen.route,
        icon = R.drawable.home_icon,
        iconTextId = R.string.home,
        labelId = R.string.beranda
    ),
    MiniMisiTopLevelDestination(
        route = Screen.SearchScreen.route,
        icon = R.drawable.search_icon,
        iconTextId = R.string.search,
        labelId = R.string.cari
    ),
    MiniMisiTopLevelDestination(
        route = Screen.HistoryScreen.route,
        icon = R.drawable.history_icon,
        iconTextId = R.string.history,
        labelId = R.string.riwayat
    ),
    MiniMisiTopLevelDestination(
        route = Screen.ProfileScreen.route,
        icon = R.drawable.profile_icon,
        iconTextId = R.string.profile,
        labelId = R.string.profil
    ),
)