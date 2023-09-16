package com.daffa.minimisi.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.presentation.components.GigNearbyCard
import com.daffa.minimisi.presentation.components.GigRecommendationCard
import com.daffa.minimisi.presentation.components.LoadingDialog
import com.daffa.minimisi.presentation.home.components.HomeTopSection
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate200
import com.daffa.minimisi.presentation.ui.theme.Slate25
import com.daffa.minimisi.presentation.ui.theme.Slate400
import com.daffa.minimisi.presentation.ui.theme.Slate50
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraSmall
import com.daffa.minimisi.presentation.ui.theme.SpaceLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall
import com.daffa.minimisi.presentation.util.showMessage
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<HomeViewModel>()
    val user by viewModel.user
    val userLoading by viewModel.userCardLoading
    val nearbyGigs by viewModel.nearbyGigs
    val nearbyGigsLoading by viewModel.nearbyGigsLoading

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = SpaceExtraLarge)
    ) {
        item {
            if (userLoading)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(125.dp)
                        .padding(horizontal = SpaceExtraLarge)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .shimmer()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Slate400)
                        )
                    }
                }
            else
                HomeTopSection(
                    user = user,
                    location = "Ngawi",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(125.dp)
                        .padding(horizontal = SpaceExtraLarge)
                )
            Spacer(modifier = Modifier.height(SpaceLarge))
        }

        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                item {
                    Spacer(modifier = Modifier.width(SpaceExtraLarge))
                }
                items(dummyNews.size) { index ->
                    Card {
                        Image(
                            painter = painterResource(id = dummyNews[index]),
                            contentDescription = stringResource(
                                R.string.news
                            ),
                            modifier = Modifier
                                .size(width = 340.dp, height = 200.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(SpaceMedium))
                }
                item {
                    Spacer(modifier = Modifier.width(SpaceMedium))
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(SpaceLarge))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SpaceExtraLarge),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.rekomendasi_pekerjaan),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Slate900,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = stringResource(R.string.lihat_semua),
                    style = MaterialTheme.typography.bodySmall.copy(
                        Slate400
                    )
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                item {
                    Spacer(modifier = Modifier.width(SpaceExtraLarge))
                }
                items(3) {
                    GigRecommendationCard(
                        gig = Gig(
                            gigName = "Divisi Kestari",
                            employer = "Hology 6.0 FILKOM UB",
                            wage = 35000.0,
                            location = "Malang",
                            date = "23j yang lalu",
                            tag = "Administrasi",
                            quota = 20
                        ),
                        modifier = Modifier
                            .size(
                                width = 350.dp,
                                height = 200.dp
                            )
                    )
                    Spacer(modifier = Modifier.width(SpaceMedium))
                }
                item {
                    Spacer(modifier = Modifier.width(SpaceMedium))
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(SpaceLarge))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SpaceExtraLarge),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Pekerjaan Sekitarmu",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Slate900,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = stringResource(R.string.lihat_semua),
                    style = MaterialTheme.typography.bodySmall.copy(
                        Slate400
                    )
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
        }

        if (nearbyGigsLoading)
            items(5) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(horizontal = SpaceExtraLarge)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .shimmer()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Slate400)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        else
            items(nearbyGigs.size) { index ->
                GigNearbyCard(
                    gig = nearbyGigs[index],
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(horizontal = SpaceExtraLarge)
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
    }
}

val dummyNews = listOf(
    R.drawable.news_1,
    R.drawable.news_2,
    R.drawable.news_3
)