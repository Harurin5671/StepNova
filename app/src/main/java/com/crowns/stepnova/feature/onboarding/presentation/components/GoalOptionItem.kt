package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.ui.theme.OnboardingTheme

data class GoalUiModel(
    val id: String,
    val title: String,
    val isSelected: Boolean = false
)

@Composable
fun GoalOptionItem(
    goal: GoalUiModel,
    onClick: (GoalUiModel) -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (goal.isSelected) OnboardingTheme.colors.selectedOptionText else StepNovaTheme.colors.textPrimary,
        label = "text_color_animation"
    )

    SelectableBorderContainer(
        isSelected = goal.isSelected,
        selectedBackgroundColor = OnboardingTheme.colors.selectedOptionBackground,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = { onClick(goal) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = goal.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = textColor
            )

            AnimatedRoundedCheckbox(
                checked = goal.isSelected,
                onCheckedChange = { onClick(goal) }
            )
        }
    }
}