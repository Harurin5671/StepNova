package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.feature.onboarding.domain.model.ActivityLevel
import com.crowns.stepnova.feature.onboarding.domain.model.FitnessGoal

@Composable
fun GoalsScreen(
    activityLevel: ActivityLevel,
    fitnessGoal: FitnessGoal,
    onActivityLevelChange: (ActivityLevel) -> Unit,
    onFitnessGoalChange: (FitnessGoal) -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "What are your goals?", // Replace with string resource
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        ActivityLevelSelector(activityLevel, onActivityLevelChange)
        Spacer(modifier = Modifier.height(24.dp))
        FitnessGoalSelector(fitnessGoal, onFitnessGoalChange)

        // TODO: Conditionally show Target Weight input if goal is weight-related

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = onNextClick) {
            Text(text = "Next") // Replace with string resource
        }
    }
}

@Composable
private fun ActivityLevelSelector(selectedLevel: ActivityLevel, onSelect: (ActivityLevel) -> Unit) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
        Text("Activity Level", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            ActivityLevel.entries.forEach { level ->
                val isSelected = selectedLevel == level
                if (isSelected) {
                    Button(onClick = { onSelect(level) }, modifier = Modifier.fillMaxWidth()) {
                        Text(level.name.replaceFirstChar { it.uppercase() })
                    }
                } else {
                    OutlinedButton(onClick = { onSelect(level) }, modifier = Modifier.fillMaxWidth()) {
                        Text(level.name.replaceFirstChar { it.uppercase() })
                    }
                }
            }
        }
    }
}

@Composable
private fun FitnessGoalSelector(selectedGoal: FitnessGoal, onSelect: (FitnessGoal) -> Unit) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
        Text("Fitness Goal", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.fillMaxWidth()) {
            FitnessGoal.entries.forEach { goal ->
                val isSelected = selectedGoal == goal
                if (isSelected) {
                    Button(onClick = { onSelect(goal) }, modifier = Modifier.weight(1f)) {
                        Text(goal.name.replace('_', ' ').replaceFirstChar { it.uppercase() })
                    }
                } else {
                    OutlinedButton(onClick = { onSelect(goal) }, modifier = Modifier.weight(1f)) {
                        Text(goal.name.replace('_', ' ').replaceFirstChar { it.uppercase() })
                    }
                }
            }
        }
    }
}
