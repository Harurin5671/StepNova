package com.crowns.stepnova.feature.onboarding.presentation

import androidx.compose.runtime.Composable
import com.crowns.stepnova.navigation.OnboardingNavigation

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    // OnboardingNavigation will now manage the entire onboarding flow.
    // We will pass the onFinished lambda down to the final screen of the flow.
    OnboardingNavigation(onFinished = onFinished)
}
