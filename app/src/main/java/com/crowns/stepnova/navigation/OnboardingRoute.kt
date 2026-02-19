package com.crowns.stepnova.navigation

import kotlinx.serialization.Serializable

sealed class OnboardingRoute {
    @Serializable
    object Welcome : OnboardingRoute()

    // Add other onboarding routes here later
    // @Serializable
    // object PersonalData : OnboardingRoute()
    // @Serializable
    // object BodyMeasures : OnboardingRoute()
    // @Serializable
    // object Goals : OnboardingRoute()
    // @Serializable
    // object Permissions : OnboardingRoute()
    // @Serializable
    // object Summary : OnboardingRoute()
}
