package com.crowns.stepnova.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.*
import androidx.navigation3.ui.NavDisplay
import com.crowns.stepnova.feature.onboarding.presentation.screen.BodyMeasuresScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.GoalsScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.PermissionsScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.PersonalDataScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.SummaryScreen
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
                    onNextClick = { backStack.add(PersonalData) }
                )
            }
            entry<PersonalData> {
                PersonalDataScreen(
                    name = uiState.name,
                    age = uiState.age,
                    gender = uiState.gender,
                    onNameChange = viewModel::onNameChange,
                    onAgeChange = viewModel::onAgeChange,
                    onGenderChange = viewModel::onGenderChange,
                    onNextClick = { backStack.add(BodyMeasures) }
                )
            }
            entry<BodyMeasures> {
                BodyMeasuresScreen(
                    height = uiState.height,
                    weight = uiState.weight,
                    onHeightChange = viewModel::onHeightChange,
                    onWeightChange = viewModel::onWeightChange,
                    onNextClick = { backStack.add(Goals) }
                )
            }
            entry<Goals> {
                GoalsScreen(
                    activityLevel = uiState.activityLevel,
                    fitnessGoal = uiState.fitnessGoal,
                    onActivityLevelChange = viewModel::onActivityLevelChange,
                    onFitnessGoalChange = viewModel::onFitnessGoalChange,
                    onNextClick = { backStack.add(Permissions) }
                )
            }
            entry<Permissions> {
                PermissionsScreen(
                    onNextClick = { backStack.add(Summary) }
                )
            }
            entry<Summary> {
                SummaryScreen(
                    state = uiState,
                    onFinishedClick = {
                        viewModel.saveOnboardingData()
                        onFinished()
                    }
                )
            }
        }
    )
}
