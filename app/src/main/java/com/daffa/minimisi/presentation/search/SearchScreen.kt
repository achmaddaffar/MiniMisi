package com.daffa.minimisi.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.ui.theme.Slate400
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<SearchViewModel>()

    Column(
        modifier = Modifier
            .padding(SpaceExtraLarge)
    ) {
        TextField(
            value = viewModel.searchQuery.value,
            onValueChange = {
                viewModel.setSearchQuery(it)
            },
            label = { Text(text = "Cari") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = stringResource(
                        id = R.string.search
                    ),
                    tint = Slate400
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}