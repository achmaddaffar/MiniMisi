package com.daffa.minimisi.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.presentation.home.components.HomeTopSection
import com.daffa.minimisi.presentation.ui.theme.Slate400
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium

@Composable
fun HomeScreen(
    navController: NavController,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = SpaceExtraLarge)
    ) {
        item {
            HomeTopSection(
                user = User(
                    "Daffa Gaming"
                ),
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
            Spacer(modifier = Modifier.height(SpaceMedium))
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
                        color = Slate900
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
                items(3) {
                    
                }
            }
        }
    }
}

val dummyNews = listOf(
    R.drawable.news_1,
    R.drawable.news_2,
    R.drawable.news_3
)