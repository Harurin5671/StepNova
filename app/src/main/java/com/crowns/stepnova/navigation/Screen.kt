package com.crowns.stepnova.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Screen : NavKey

// App-level screens
@Serializable
data object Onboarding : Screen // The entire onboarding flow

@Serializable
data object Main : Screen // The main app content (with bottom bar)

// Onboarding steps
@Serializable
data object Welcome : Screen

@Serializable
data object PersonalData : Screen

@Serializable
data object BodyMeasures : Screen

@Serializable
data object Goals : Screen

@Serializable
data object Permissions : Screen

@Serializable
data object Summary : Screen

// Main app screens (bottom bar)
@Serializable
data object Activity : Screen

@Serializable
data object Insights : Screen

@Serializable
data object Nutrition : Screen

@Serializable
data object Account : Screen
