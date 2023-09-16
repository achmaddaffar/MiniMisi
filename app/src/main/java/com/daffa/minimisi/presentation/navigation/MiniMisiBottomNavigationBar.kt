package com.daffa.minimisi.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate300

@Composable
fun MiniMisiBottomNavigationBar(
    selectedDestination: String,
    navigateToTopLevelDestination: (MiniMisiTopLevelDestination) -> Unit,
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        TOP_LEVEL_DESTINATION.forEach { destination ->
            NavigationBarItem(
                selected = selectedDestination == destination.route,
                onClick = { navigateToTopLevelDestination(destination) },
                label = {
                    Text(
                        text = stringResource(destination.labelId),
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = stringResource(id = destination.iconTextId),
                        tint = if (selectedDestination == destination.route) Primary500 else Slate300
                    )
                }
            )
        }
    }
}