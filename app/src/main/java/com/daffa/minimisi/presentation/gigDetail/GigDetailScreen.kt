package com.daffa.minimisi.presentation.gigDetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Badge
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.components.LoadingDialog
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate100
import com.daffa.minimisi.presentation.ui.theme.Slate500
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraSmall
import com.daffa.minimisi.presentation.ui.theme.SpaceLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GigDetailScreen(
    navController: NavController,
    id: String?,
) {
    val viewModel = koinViewModel<GigDetailViewModel>()
    val isLoading by viewModel.isLoading
    val gig by viewModel.gig
    val pagerState = rememberPagerState { 2 }

    LaunchedEffect(key1 = true) {
        viewModel.getNearbyGigsById(id.toString())
    }

    if (isLoading)
        LoadingDialog()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceExtraLarge)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = stringResource(
                    id = R.string.back_icon
                ),
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.width(SpaceExtraSmall))
            Text(
                text = stringResource(R.string.detail),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Slate900,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = gig.item?.gigName.toString(),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(SpaceExtraSmall))
            Text(
                text = gig.item?.employer.toString(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(SpaceExtraSmall))
            Badge(
                modifier = Modifier.padding(SpaceExtraSmall),
                backgroundColor = Primary500
            ) {
                Text(
                    text = gig.item?.tag.toString(),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(SpaceMedium))
        Card {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceLarge),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Imbas Hasil",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(SpaceExtraSmall))
                    Text(
                        text = gig.item?.wage.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tanggal",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(SpaceExtraSmall))
                    Text(
                        text = gig.item?.deadline.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(SpaceMedium))
        Card {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium),
            ) {
                Text(
                    text = "Kuota Pendaftar",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(SpaceExtraSmall))
                LinearProgressIndicator(
                    progress = 3 / 4f,
                    trackColor = Slate100,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(SpaceSmall)
                )
                Spacer(modifier = Modifier.height(SpaceExtraSmall))
                Text(
                    text = "Sisa ${gig.item?.quota} Slot",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Slate500
                    )
                )
            }
        }

        HorizontalPager(
            state = pagerState
        ) {
            Row {

            }
        }
    }
}