package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.components.GoalOptionList
import com.crowns.stepnova.feature.onboarding.presentation.components.GoalUiModel
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState


@Composable
fun FitnessGoalScreen(
    onNextClick: () -> Unit,
    navState: OnboardingNavState,
) {
    var options by remember {
        mutableStateOf(
            listOf(
                GoalUiModel(id = "1", title = "I wanna lose weight", isSelected = false),
                GoalUiModel(id = "2", title = "I wanna try AI Coach", isSelected = true),
                GoalUiModel(id = "3", title = "I wanna get bulks", isSelected = false),
                GoalUiModel(id = "4", title = "I wanna gain endurance", isSelected = false),
                GoalUiModel(
                    id = "5",
                    title = "Just trying out the app! \uD83D\uDC4D",
                    isSelected = false
                )
            )
        )
    }

    OnboardingStepLayout(
        title = "What’s your fitness goal/target?",
        onNextClick = onNextClick,
        navState = navState,
    ) {
        Spacer(Modifier.height(48.dp))

        GoalOptionList(
            goals = options,
        ) { selectedGoal ->
            options = options.map { goal ->
                goal.copy(isSelected = goal.id == selectedGoal.id)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = false) {
        FitnessGoalScreen(
            onNextClick = {},
            navState = navState
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        FitnessGoalScreen(
            onNextClick = {},
            navState = navState
        )
    }
}
