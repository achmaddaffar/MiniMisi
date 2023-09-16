package com.daffa.minimisi.presentation.navigation

import androidx.annotation.DrawableRes

data class MiniMisiTopLevelDestination(
    val route: String,
    @DrawableRes val icon: Int,
    val iconTextId: Int,
    val labelId: Int
)