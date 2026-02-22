package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState

@Composable
fun WeightScreen(
    navState: OnboardingNavState
) {
    OnboardingStepLayout(
        title = "What is your weight?",
        onNextClick = {},
        navState = navState
    ) { }
}

@Preview
@Composable
fun LightWeight() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme() {
        WeightScreen(
            navState = navState
        )
    }
}

@Preview
@Composable
fun DarkWeight() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        WeightScreen(
            navState = navState
        )
    }
}