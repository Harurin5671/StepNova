package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.presentation.screen.AnimatedRoundedCheckbox

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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = StepNovaTheme.colors.surface,
                shape = RoundedCornerShape(19.dp)
            )
            .clickable { onClick(goal) }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = goal.title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = StepNovaTheme.colors.textPrimary
        )

        AnimatedRoundedCheckbox(
            checked = goal.isSelected,
            onCheckedChange = { onClick(goal) }
        )
    }
}