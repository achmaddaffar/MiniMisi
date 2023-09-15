package com.daffa.minimisi.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daffa.minimisi.R
import com.daffa.minimisi.presentation.ui.theme.IconSizeMedium
import com.daffa.minimisi.presentation.ui.theme.Slate300
import com.daffa.minimisi.presentation.ui.theme.Slate500
import com.daffa.minimisi.presentation.util.Empty

@Composable
fun MiniMisiTextField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    maxLength: Int = 40,
    error: String = String.Empty,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: Painter? = null,
    leadingIconColor: Color? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed: Boolean = keyboardType == KeyboardType.Password,
    fieldColor: Color,
    outlineColor: Color = Slate500,
    shape: Shape = MaterialTheme.shapes.medium,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            maxLines = maxLines,
            textStyle = textStyle,
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body1.copy(
                        color = Slate300
                    )
                )
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            singleLine = singleLine,
            visualTransformation = if (!showPasswordToggle && isPasswordToggleDisplayed) PasswordVisualTransformation() else VisualTransformation.None,
            leadingIcon = if (leadingIcon != null) {
                {
                    Icon(
                        painter = leadingIcon,
                        contentDescription = null,
                        tint = leadingIconColor ?: Color.Unspecified,
                        modifier = Modifier.size(IconSizeMedium)
                    )
                }
            } else null,
            trailingIcon = if (isPasswordToggleDisplayed) {
                {
                    IconButton(
                        onClick = {
                            onPasswordToggleClick(!showPasswordToggle)
                        }) {
                        Icon(
                            painter = if (showPasswordToggle)
                                painterResource(id = R.drawable.eye_closed) else painterResource(
                                id = R.drawable.eye_open
                            ),
                            contentDescription = if (showPasswordToggle) {
                                stringResource(R.string.sembunyikan_password)
                            } else {
                                stringResource(R.string.perlihatkan_password)
                            },
                            modifier = Modifier.size(IconSizeMedium)
                        )
                    }
                }
            } else null,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = outlineColor,
                    shape = shape
                ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = fieldColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                errorLeadingIconColor = MaterialTheme.colors.error
            )
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}