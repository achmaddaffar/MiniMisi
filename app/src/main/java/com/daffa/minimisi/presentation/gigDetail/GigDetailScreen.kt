package com.daffa.minimisi.presentation.gigDetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.components.LoadingDialog
import com.daffa.minimisi.presentation.ui.theme.Slate900
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraSmall
import org.koin.androidx.compose.koinViewModel

@Composable
fun GigDetailScreen(
    navController: NavController,
    id: String?,
) {
    val viewModel = koinViewModel<GigDetailViewModel>()
    val isLoading by viewModel.isLoading
    val gig by viewModel.gig

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
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
    }
}