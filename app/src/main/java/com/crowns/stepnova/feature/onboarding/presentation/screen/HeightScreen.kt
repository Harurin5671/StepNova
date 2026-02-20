package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout

@Composable
fun HeightScreen(
    backStack: NavBackStack<NavKey>
) {
    OnboardingStepLayout(
        title = "What is your age?",
        backStack = backStack,
        onNextClick = {}
    ) { }
}

@Preview
@Composable
fun LightHeight() {
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme() {
        HeightScreen(
            backStack = backStack
        )
    }
}

@Preview
@Composable
fun DarkHeight() {
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme(darkTheme = true) {
        HeightScreen(
            backStack = backStack
        )
    }
}