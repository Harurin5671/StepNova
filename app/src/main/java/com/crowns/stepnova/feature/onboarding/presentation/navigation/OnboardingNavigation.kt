package com.crowns.stepnova.feature.onboarding.presentation.navigation

//import androidx.compose.runtime.getValue
//import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.crowns.stepnova.core.ex.back
import com.crowns.stepnova.core.ex.navigateTo
import com.crowns.stepnova.feature.onboarding.presentation.screen.FitnessGoalScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.GenderScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.WelcomeScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.age.AgeScreen
import com.crowns.stepnova.feature.onboarding.presentation.screen.weight.WeightScreen

//import com.crowns.stepnova.feature.onboarding.presentation.viewmodel.OnboardingViewModel

data class OnboardingNavState(
    val canGoBack: Boolean,
    val currentStep: Int?,
    val totalSteps: Int,
    val onBackClick: () -> Unit,
)

private val onboardingSteps = listOf(
    FitnessGoal,
    Gender,
    Weight,
    Age
)

@Composable
fun OnboardingNavigation(
//    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val backStack = rememberNavBackStack(Welcome)
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val currentKey = backStack.lastOrNull()
    val currentStepIndex = onboardingSteps.indexOf(currentKey)

    val navState = OnboardingNavState(
        canGoBack = backStack.size > 1,
        currentStep = if (currentStepIndex != -1) currentStepIndex + 1 else null,
        totalSteps = onboardingSteps.size,
        onBackClick = { backStack.back() }
    )

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<Welcome> {
                WelcomeScreen(
                    onNextClick = { backStack.navigateTo(FitnessGoal) }
                )
            }
            entry<FitnessGoal> {
                FitnessGoalScreen(
                    onNextClick = { backStack.navigateTo(Gender) },
                    navState = navState
                )
            }
            entry<Gender> {
                GenderScreen(
                    onNextClick = { backStack.navigateTo(Weight) },
                    navState = navState
                )
            }
            entry<Weight> {
                WeightScreen(
                    onNextClick = { backStack.navigateTo(Age) },
                    navState = navState
                )
            }
            entry<Age> {
                AgeScreen(
                    onNextClick = {},
                    navState = navState
                )
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(250)
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(250)
            )
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(250)
            )
        }
    )
}
