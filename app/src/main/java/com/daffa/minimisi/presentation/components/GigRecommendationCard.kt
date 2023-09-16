package com.daffa.minimisi.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.daffa.minimisi.R
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Primary600
import com.daffa.minimisi.presentation.ui.theme.Slate25
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraSmall
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GigRecommendationCard(
    modifier: Modifier = Modifier,
    gig: Gig,
) {
    Card {
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary600)
                    .padding(SpaceSmall),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Badge(
                    containerColor = Slate900,
                    modifier = Modifier.padding(SpaceSmall)
                ) {
                    Text(
                        text = "Administrasi",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Slate25
                        )
                    )
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.clock_icon),
                        contentDescription = stringResource(R.string.clock)
                    )
                    Spacer(modifier = Modifier.width(SpaceExtraSmall))
                    Text(
                        text = gig.date,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Slate25
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary500)
                    .padding(SpaceMedium)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.gig_doodle),
                    contentDescription = stringResource(
                        R.string.gig_doodle
                    ),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .scale(1.2f)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                ) {
                    Text(
                        text = gig.gigName,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            color = Slate25,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(SpaceExtraSmall))
                    Text(
                        text = gig.employer,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Slate25
                        )
                    )
                }
                Text(
                    text = "Rp. ${gig.wage}",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Slate25,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.location_icon),
                        contentDescription = stringResource(
                            id = R.string.location
                        ),
                        tint = Slate25
                    )
                    Spacer(modifier = Modifier.width(SpaceExtraSmall))
                    Text(
                        text = gig.location,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Slate25
                        )
                    )
                }
            }
        }
    }
}