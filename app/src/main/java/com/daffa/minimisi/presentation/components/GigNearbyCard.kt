package com.daffa.minimisi.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.daffa.minimisi.R
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate25
import com.daffa.minimisi.presentation.ui.theme.Slate400
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraSmall
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GigNearbyCard(
    modifier: Modifier = Modifier,
    gig: Gig
) {
    Card(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(SpaceMedium)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Text(
                    text = gig.gigName,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Slate900,
                        fontWeight = FontWeight.Bold
                    )
                )
                Badge(
                    containerColor = Primary500,
                    modifier = Modifier.padding(SpaceSmall)
                ) {
                    Text(
                        text = gig.tag,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Slate25
                        )
                    )
                }
            }

            Text(
                text = "Rp. ${gig.wage}",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Slate900,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.clock_icon),
                    contentDescription = stringResource(R.string.clock),
                    tint = Slate400
                )
                Spacer(modifier = Modifier.width(SpaceExtraSmall))
                Text(
                    text = gig.date,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Slate400
                    )
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location_icon),
                    contentDescription = stringResource(
                        id = R.string.location
                    ),
                    tint = Slate400
                )
                Spacer(modifier = Modifier.width(SpaceExtraSmall))
                Text(
                    text = gig.distance.toString(),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Slate400,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}