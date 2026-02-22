package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState

@Composable
fun HeightScreen(
    navState: OnboardingNavState
) {
    OnboardingStepLayout(
        title = "What is your age?",
        onNextClick = {},
        navState = navState

    ) { }
}

@Preview
@Composable
fun LightHeight() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme() {
        HeightScreen(
            navState = navState
        )
    }
}

@Preview
@Composable
fun DarkHeight() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        HeightScreen(
            navState = navState
        )
    }
}