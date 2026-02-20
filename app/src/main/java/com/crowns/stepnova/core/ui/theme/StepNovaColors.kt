package com.crowns.stepnova.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class StepNovaColors(
    // Brand
    val primary: Color,
    val onPrimary: Color,

    // Backgrounds
    val background: Color,
    val surface: Color,
    val card: Color,

    // Text
    val textPrimary: Color,
    val textSecondary: Color,
    val textDisabled: Color,

    // Border
    val border: Color,
    val borderStrong: Color,

    // Status
    val success: Color,
    val warning: Color,
    val error: Color,

    // Onboarding Special
    val onboardingBtnNext: Color,
    val onboardingNavigationIcon: Color,
    val onboardingTagContainer: Color,
)

val LightStepNovaColors = StepNovaColors(

    primary = pulseOrange50,
    onPrimary = sandowGrayWhite,

    background = sandowGrayWhite,
    surface = sandowGray10,
    card = sandowGrayWhite,

    textPrimary = sandowGray100,
    textSecondary = sandowGray60,
    textDisabled = sandowGray40,

    border = sandowGray20,
    borderStrong = sandowGray40,

    success = spinachGreen60,
    warning = calorieYellow60,
    error = enduranceRed60,

    onboardingBtnNext = sandowGray100,
    onboardingNavigationIcon = sandowGray10,
    onboardingTagContainer = tabataBlue10
)

val DarkStepNovaColors = StepNovaColors(

    primary = pulseOrange50,
    onPrimary = sandowGrayWhite,

    background = sandowGray100,
    surface = sandowGray90,
    card = sandowGray90,

    textPrimary = sandowGrayWhite,
    textSecondary = sandowGray40,
    textDisabled = sandowGray60,

    border = sandowGray85,
    borderStrong = sandowGray70,

    success = spinachGreen50,
    warning = calorieYellow50,
    error = enduranceRed50,

    onboardingBtnNext = pulseOrange50,
    onboardingNavigationIcon = sandowGray80,
    onboardingTagContainer = tabataBlue100
)
