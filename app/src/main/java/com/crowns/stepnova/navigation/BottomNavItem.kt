package com.crowns.stepnova.navigation

import androidx.navigation3.runtime.NavKey

data class BottomNavItem(
    val label: String,
    val destination: NavKey
)