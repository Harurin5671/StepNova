package com.crowns.stepnova.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Screen : NavKey

@Serializable
data object Onboarding : Screen

@Serializable
data object Main : Screen


@Serializable
data object Activity : Screen

@Serializable
data object Insights : Screen

@Serializable
data object Nutrition : Screen