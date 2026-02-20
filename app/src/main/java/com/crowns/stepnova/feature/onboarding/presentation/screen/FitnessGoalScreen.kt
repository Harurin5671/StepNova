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
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.domain.model.ActivityLevel
import com.crowns.stepnova.feature.onboarding.domain.model.FitnessGoal
import com.crowns.stepnova.feature.onboarding.presentation.components.GoalOptionList
import com.crowns.stepnova.feature.onboarding.presentation.components.GoalUiModel
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout


@Composable
fun FitnessGoalScreen(
    backStack: NavBackStack<NavKey>,
    activityLevel: ActivityLevel,
    fitnessGoal: FitnessGoal,
    onActivityLevelChange: (ActivityLevel) -> Unit,
    onFitnessGoalChange: (FitnessGoal) -> Unit,
    onNextClick: () -> Unit
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
        backStack = backStack,
        onNextClick = onNextClick
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
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme(darkTheme = false) {
        FitnessGoalScreen(
            activityLevel = ActivityLevel.SEDENTARY,
            backStack = backStack,
            fitnessGoal = FitnessGoal.MAINTAIN_WEIGHT,
            onActivityLevelChange = {},
            onFitnessGoalChange = {},
            onNextClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    val backStack = NavBackStack<NavKey>()
    StepNovaTheme(darkTheme = true) {
        FitnessGoalScreen(
            activityLevel = ActivityLevel.SEDENTARY,
            backStack = backStack,
            fitnessGoal = FitnessGoal.MAINTAIN_WEIGHT,
            onActivityLevelChange = {},
            onFitnessGoalChange = {},
            onNextClick = {}
        )
    }
}
