package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout

@Composable
fun WeightScreen(
    backStack: NavBackStack<NavKey>
) {
    OnboardingStepLayout(
        title = "What is your weight?",
        backStack = backStack,
        onNextClick = {}
    ) { }
}

@Preview
@Composable
fun LightWeight() {
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme() {
        WeightScreen(
            backStack = backStack
        )
    }
}

@Preview
@Composable
fun DarkWeight() {
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme(darkTheme = true) {
        WeightScreen(
            backStack = backStack
        )
    }
}