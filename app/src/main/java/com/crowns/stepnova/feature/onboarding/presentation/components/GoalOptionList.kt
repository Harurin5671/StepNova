package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun GoalOptionList(
    goals: List<GoalUiModel>,
    onGoalSelected: (GoalUiModel) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(goals) { goal ->
            GoalOptionItem(
                goal = goal,
                onClick = onGoalSelected
            )
        }
    }
}