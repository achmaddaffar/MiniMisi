package com.daffa.minimisi.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.daffa.minimisi.R
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.presentation.components.LoadingDialog
import com.daffa.minimisi.presentation.components.MiniMisiTextField
import com.daffa.minimisi.presentation.ui.theme.IconSizeMedium
import com.daffa.minimisi.presentation.ui.theme.Primary500
import com.daffa.minimisi.presentation.ui.theme.Slate25
import com.daffa.minimisi.presentation.ui.theme.Slate600
import com.daffa.minimisi.presentation.ui.theme.SpaceExtraLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceExtremeLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceLarge
import com.daffa.minimisi.presentation.ui.theme.SpaceMedium
import com.daffa.minimisi.presentation.ui.theme.SpaceSmall
import com.daffa.minimisi.presentation.ui.theme.Typography
import com.daffa.minimisi.presentation.util.Navigation
import com.daffa.minimisi.presentation.util.Screen
import com.daffa.minimisi.presentation.util.showMessage
import com.daffa.minimisi.presentation.util.state.TextFieldState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<LoginViewModel>()
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    var isDialog by remember { mutableStateOf(false) }

    if (isDialog)
        LoadingDialog()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical
            )
            .padding(
                SpaceExtraLarge
            ),
        horizontalAlignment = Alignment.Start
    ) {
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .size(IconSizeMedium)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = stringResource(R.string.back_icon),
            )
        }

        Spacer(modifier = Modifier.height(SpaceExtremeLarge))

        Text(
            text = stringResource(R.string.hai_jumpa_kembali),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(SpaceMedium))

        Text(
            text = stringResource(R.string.login_desc),
            style = MaterialTheme.typography.bodySmall.copy(color = Color.Black)
        )

        Spacer(modifier = Modifier.height(SpaceLarge))

        MiniMisiTextField(
            fieldColor = Color.White,
            onValueChange = {
                viewModel.setEmailText(
                    TextFieldState(
                        text = it
                    )
                )
            },
            text = viewModel.emailText.value.text,
            error = viewModel.emailText.value.error,
            hint = stringResource(R.string.email),
            leadingIcon = painterResource(id = R.drawable.email_icon),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(SpaceMedium))

        MiniMisiTextField(
            fieldColor = Color.White,
            onValueChange = {
                viewModel.setPasswordText(
                    TextFieldState(
                        text = it
                    )
                )
            },
            text = viewModel.passwordText.value.text,
            error = viewModel.passwordText.value.error,
            hint = stringResource(R.string.password),
            leadingIcon = painterResource(id = R.drawable.password_icon),
            keyboardType = KeyboardType.Password,
            showPasswordToggle = viewModel.showPassword.value,
            onPasswordToggleClick = {
                viewModel.setShowPassword(it)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(SpaceMedium))

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            viewModel.login().collect {
                                isDialog = when(it) {
                                    is Resource.Success -> {
                                        context.showMessage(it.data.toString())
                                        navController.navigate(Screen.HomeScreen.route) {
                                            popUpTo(navController.graph.id) {
                                                inclusive = true
                                            }
                                        }
                                        false
                                    }
                                    is Resource.Error -> {
                                        context.showMessage(it.message.toString())
                                        false
                                    }
                                    is Resource.Loading -> {
                                        true
                                    }
                                }
                            }
                        }
                    },
                    enabled = viewModel.isFieldFilled(),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.masuk),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Slate25
                        )
                    )
                }
                Spacer(modifier = Modifier.height(SpaceSmall))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.belum_punya_akun),
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Slate600
                        )
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = stringResource(R.string.daftar_sekarang),
                        style = Typography.bodySmall.copy(
                            color = Primary500,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.RegisterScreen.route) {
                                popUpTo(Screen.LoginScreen.route) {
                                    inclusive = true
                                    saveState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}