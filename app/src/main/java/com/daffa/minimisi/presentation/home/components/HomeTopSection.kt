package com.daffa.minimisi.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.daffa.minimisi.R
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.presentation.ui.theme.IconSizeMedium
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraSmall
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall

@Composable
fun HomeTopSection(
    modifier: Modifier = Modifier,
    user: User,
    location: String,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = stringResource(R.string.home_greeting),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Slate900
                )
            )
            Spacer(modifier = Modifier.height(SpaceExtraSmall))
            Text(
                text = "${user.username}!",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Slate900,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location_icon),
                    contentDescription = stringResource(R.string.location)
                )
                Spacer(modifier = Modifier.width(SpaceExtraSmall))
                Text(
                    text = "Lokasimu saat ini ",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Slate900
                    )
                )
                Text(
                    text = location,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Primary500,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = user.profilePictureUrl ?: R.drawable.profile_picture,
                contentDescription = stringResource(R.string.profile_picture),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
            )
        }
    }
}