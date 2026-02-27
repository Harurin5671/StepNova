package com.crowns.stepnova.feature.onboarding.presentation.screen.weight

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState
import com.crowns.stepnova.feature.onboarding.presentation.screen.weight.components.UnitToggle
import com.crowns.stepnova.feature.onboarding.presentation.screen.weight.components.WeightRulerPicker

@Composable
fun WeightScreen(
    navState: OnboardingNavState
) {
    var isKg by remember { mutableStateOf(true) }
    var weightInKg by remember { mutableStateOf(128f) }

    val displayValue: Float
    val unit: String
    val min: Float
    val max: Float

    if (isKg) {
        displayValue = weightInKg
        unit = "kg"
        min = 30f
        max = 250f
    } else {
        displayValue = weightInKg * 2.20462f
        unit = "lbs"
        min = 66f
        max = 550f
    }

    OnboardingStepLayout(
        title = "What is your weight?",
        onNextClick = {},
        navState = navState
    ) {
        UnitToggle(isKg = isKg, onToggle = { selectedIsKg -> isKg = selectedIsKg })
        WeightRulerPicker(
            value = displayValue,
            onValueChange = { newDisplayValue ->
                weightInKg = if (isKg) {
                    newDisplayValue
                } else {
                    newDisplayValue / 2.20462f
                }
            },
            unit = unit,
            minValue = min,
            maxValue = max
        )
    }
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

    StepNovaTheme {
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
