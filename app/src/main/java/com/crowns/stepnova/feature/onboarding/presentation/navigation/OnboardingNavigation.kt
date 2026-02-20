package com.crowns.stepnova.feature.onboarding.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.crowns.stepnova.feature.onboarding.presentation.screen.FitnessGoalScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.GenderScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.WelcomeScreen
import com.crowns.stepnova.feature.onboarding.presentation.viewmodel.OnboardingViewModel

@Composable
fun OnboardingNavigation(
    onFinished: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val backStack = rememberNavBackStack(Welcome)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Welcome> {
                WelcomeScreen(
                    onNextClick = { backStack.add(FitnessGoal) }
                )
            }
            entry<FitnessGoal> {
                FitnessGoalScreen(
                    activityLevel = uiState.activityLevel,
                    backStack = backStack,
                    fitnessGoal = uiState.fitnessGoal,
                    onActivityLevelChange = viewModel::onActivityLevelChange,
                    onFitnessGoalChange = viewModel::onFitnessGoalChange,
                    onNextClick = { backStack.add(Gender) }
                )
            }
            entry<Gender> {
                GenderScreen(
                    backStack = backStack
                )
            }
        }
    )
}
