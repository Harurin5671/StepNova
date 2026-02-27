package com.crowns.stepnova.feature.onboarding.presentation.screen.age

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState
import com.crowns.stepnova.feature.onboarding.presentation.screen.age.components.AgePicker

@Composable
fun AgeScreen(
    onNextClick: () -> Unit,
    navState: OnboardingNavState
) {
    OnboardingStepLayout(
        title = "What is your age?",
        onNextClick = onNextClick,
        navState = navState
    ) {
        AgePicker(selectedAge = 18, onAgeSelected = {})
    }
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 2,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme() {
        AgeScreen(
            onNextClick = {},
            navState = navState,
        )
    }
}

@Preview()
@Composable
fun DarkPreview() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 2,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        AgeScreen(
            onNextClick = {},
            navState = navState,
        )
    }
}