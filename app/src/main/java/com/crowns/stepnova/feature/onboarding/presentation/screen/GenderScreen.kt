package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState

@Composable
fun GenderScreen(
    navState: OnboardingNavState
) {
    OnboardingStepLayout(
        title = "What is your gender?",
        onNextClick = {},
        navState = navState
    ) {}
}

@Preview
@Composable
fun LightGender() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme {
        GenderScreen(
            navState = navState
        )
    }
}

@Preview
@Composable
fun DarkGender() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        GenderScreen(
            navState = navState
        )
    }
}