package com.crowns.stepnova.navigation

import androidx.annotation.DrawableRes
import androidx.navigation3.runtime.NavKey

data class BottomNavItem(
    val label: String,
    val destination: NavKey,
    @param:DrawableRes val iconRes: Int,
    @param:DrawableRes val iconSelectRes: Int,
    @param:DrawableRes val iconSelectDarkRes: Int = iconRes,
)