package com.crowns.stepnova.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.crowns.stepnova.feature.onboarding.presentation.OnboardingScreen

@Composable
fun RootNavigation() {
    val hasCompletedOnboarding = false

    val startDestination = if (hasCompletedOnboarding) Main else Onboarding
    val backStack = rememberNavBackStack(startDestination)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Onboarding> {
                OnboardingScreen(
                    onFinished = {
                        backStack.popBackTo(Onboarding) { inclusive = true }
                        backStack.add(Main)
                    }
                )
            }
            entry<Main> {
                AppNavigation()
            }
        }
    )
}