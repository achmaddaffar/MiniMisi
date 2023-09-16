package com.daffa.minimisi.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import com.daffa.minimisi.presentation.util.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<ProfileViewModel>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceExtraLarge),
    ) {
        Button(
            onClick = {
                viewModel.logout()
                navController.navigate(Screen.SplashScreen.route) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text(text = "Logout")
        }
    }
}