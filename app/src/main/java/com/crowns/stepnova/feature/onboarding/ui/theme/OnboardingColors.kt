package com.crowns.stepnova.feature.onboarding.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.crowns.stepnova.core.ui.theme.pulseOrange50
import com.crowns.stepnova.core.ui.theme.sandowGray10
import com.crowns.stepnova.core.ui.theme.sandowGray100
import com.crowns.stepnova.core.ui.theme.sandowGray80
import com.crowns.stepnova.core.ui.theme.tabataBlue10
import com.crowns.stepnova.core.ui.theme.tabataBlue100

data class OnboardingColors(
    val nextButton: Color,
    val navigationIcon: Color,
    val tagContainer: Color,
    val selectedOptionBackground: Color
)

val LightOnboardingColors = OnboardingColors(
    nextButton = sandowGray100,
    navigationIcon = sandowGray10,
    tagContainer = tabataBlue10,
    selectedOptionBackground = pulseOrange50
)

val DarkOnboardingColors = OnboardingColors(
    nextButton = pulseOrange50,
    navigationIcon = sandowGray80,
    tagContainer = tabataBlue100,
    selectedOptionBackground = sandowGray80
)

val LocalOnboardingColors = staticCompositionLocalOf<OnboardingColors> {
    error("No OnboardingColors provided")
}

object OnboardingTheme {
    val colors: OnboardingColors
        @Composable
        get() = LocalOnboardingColors.current
}