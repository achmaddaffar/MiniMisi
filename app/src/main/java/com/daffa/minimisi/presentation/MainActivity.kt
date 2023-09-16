package com.daffa.minimisi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daffa.minimisi.presentation.navigation.MiniMisiBottomNavigationBar
import com.daffa.minimisi.presentation.navigation.MiniMisiNavigationActions
import com.daffa.minimisi.presentation.navigation.TOP_LEVEL_DESTINATION
import com.daffa.minimisi.presentation.ui.theme.MiniMisiTheme
import com.daffa.minimisi.presentation.util.Navigation
import com.daffa.minimisi.presentation.util.Screen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MiniMisiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navigationActions = remember(navController) {
                        MiniMisiNavigationActions(navController)
                    }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selectedDestination =
                        navBackStackEntry?.destination?.route ?: Screen.SplashScreen.route

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        Navigation(
                            navController = navController,
                            modifier = Modifier.weight(1f)
                        )
                        AnimatedVisibility(
                            visible = selectedDestination in TOP_LEVEL_DESTINATION.map { it.route }
                        ) {
                            MiniMisiBottomNavigationBar(
                                selectedDestination = selectedDestination,
                                navigateToTopLevelDestination = navigationActions::navigateTo
                            )
                        }
                    }
                }
            }
        }
    }
}