package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout

@Composable
fun GenderScreen(
    backStack: NavBackStack<NavKey>
) {
    OnboardingStepLayout(
        title = "What is your gender?",
        backStack = backStack,
        onNextClick = {}
    ) {}
}

@Preview
@Composable
fun LightGender() {
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme() {
        GenderScreen(
            backStack = backStack
        )
    }
}

@Preview
@Composable
fun DarkGender() {
    StepNovaTheme(darkTheme = true) {
        val backStack = NavBackStack<NavKey>()
        GenderScreen(
            backStack = backStack
        )
    }
}