package com.daffa.minimisi.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class OnBoardingItem(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
    val buttonText: String
)