package com.daffa.minimisi.presentation.splash

import android.content.pm.ActivityInfo
import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.components.LockScreenOrientation
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Typography
import com.daffa.minimisi.presentation.util.Navigation
import com.daffa.minimisi.presentation.util.Screen
import com.daffa.minimisi.util.Constants
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val alpha = remember {
        Animatable(0f)
    }
    val isLoggedIn = Firebase.auth.uid != null
    val nextDestination = if (isLoggedIn) Screen.HomeScreen.route else Screen.OnBoardingScreen.route
    val systemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

    Log.e("Splash", Firebase.auth.uid.toString())

    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1500
            )
        )
        delay(Constants.SPLASH_SCREEN_DURATION)

        systemUiController.isStatusBarVisible = true
        navController.popBackStack()
        navController.navigate(nextDestination)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary500)
            .alpha(alpha.value),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.minimisi_logo),
            contentDescription = stringResource(R.string.minimisi_logo),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .padding(screenWidth / 6f)
        )
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = stringResource(R.string.splash_image),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.35f)
                .width(screenWidth)
                .scale(1.5f)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = String.format("version %.1f", 1.0),
                style = Typography.bodySmall.copy(
                    color = Color.White
                ),
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}