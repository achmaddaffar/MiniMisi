package com.daffa.minimisi.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.components.HorizontalLineIndicator
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate25
import com.daffa.minimisi.presentation.ui.theme.Slate300
import com.daffa.minimisi.presentation.ui.theme.Slate500
import com.daffa.minimisi.presentation.ui.theme.Slate600
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtremeLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall
import com.daffa.minimisi.presentation.ui.theme.Typography
import com.daffa.minimisi.presentation.util.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
) {
    val onBoardingItem = listOf<OnBoardingItem>(
        OnBoardingItem(
            image = R.drawable.onboard_image_1,
            title = stringResource(R.string.onboard_title_1),
            description = stringResource(R.string.onboard_desc_1),
            buttonText = stringResource(R.string.lanjutkan)
        ),
        OnBoardingItem(
            image = R.drawable.onboard_image_2,
            title = stringResource(R.string.onboard_title_2),
            description = stringResource(R.string.onboard_desc_2),
            buttonText = stringResource(R.string.lanjutkan)
        ),
        OnBoardingItem(
            image = R.drawable.onboard_image_3,
            title = stringResource(R.string.onboard_title_3),
            description = stringResource(R.string.onboard_desc_3),
            buttonText = stringResource(R.string.daftarkan_saya_sekarang)
        ),
    )
    val pagerState = rememberPagerState(pageCount = { onBoardingItem.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = SpaceLarge),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                modifier = Modifier
                    .alpha(if (pagerState.currentPage != onBoardingItem.size - 1) 1f else 0f),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(
                            onBoardingItem.size - 1
                        )
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        Slate900
                    )
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = onBoardingItem[pagerState.currentPage].image),
                contentDescription = stringResource(R.string.onboarding_image),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        HorizontalLineIndicator(
            pagerState = pagerState,
            selectedColor = Slate500,
            unselectedColor = Slate300,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceExtremeLarge * 2)
        )

        Text(
            text = onBoardingItem[pagerState.currentPage].title,
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Slate900
            ),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = SpaceExtremeLarge)
        )

        Text(
            text = onBoardingItem[pagerState.currentPage].description,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Slate600
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = SpaceExtremeLarge)
        )

        Button(
            onClick = {
                if (pagerState.currentPage != onBoardingItem.size - 1)
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                else
                    navController.navigate(Screen.RegisterScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = SpaceExtremeLarge)
        ) {
            Text(
                text = onBoardingItem[pagerState.currentPage].buttonText,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Slate25
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(if (pagerState.currentPage == onBoardingItem.size - 1) 1f else 0f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.sudah_punya_akun),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Slate600
                )
            )
            Spacer(modifier = Modifier.width(SpaceSmall))
            Text(
                text = stringResource(R.string.login),
                style = Typography.bodySmall.copy(
                    color = Primary500,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.clickable {
                    navController.navigate(Screen.LoginScreen.route)
                }
            )
        }
    }
}