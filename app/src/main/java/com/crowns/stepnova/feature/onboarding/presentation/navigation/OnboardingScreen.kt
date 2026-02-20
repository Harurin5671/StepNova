package com.crowns.stepnova.feature.onboarding.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface OnboardingScreen : NavKey

@Serializable
data object Welcome : OnboardingScreen

@Serializable
data object FitnessGoal : OnboardingScreen

@Serializable
data object Gender : OnboardingScreen