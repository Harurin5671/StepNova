package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.feature.onboarding.presentation.viewmodel.OnboardingState

@Composable
fun SummaryScreen(
    state: OnboardingState,
    onFinishedClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ready to go?", // Replace with string resource
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        SummaryItem(label = "Name", value = state.name)
        SummaryItem(label = "Age", value = state.age)
        SummaryItem(label = "Gender", value = state.gender.name.replaceFirstChar { it.uppercase() })
        SummaryItem(label = "Height", value = "${state.height} cm")
        SummaryItem(label = "Weight", value = "${state.weight} kg")
        SummaryItem(label = "Activity Level", value = state.activityLevel.name.replaceFirstChar { it.uppercase() })
        SummaryItem(label = "Main Goal", value = state.fitnessGoal.name.replace('_', ' ').replaceFirstChar { it.uppercase() })

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = onFinishedClick) {
            Text(text = "Finish & Start Journey") // Replace with string resource
        }
    }
}

@Composable
private fun SummaryItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Text(text = value, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
    }
}