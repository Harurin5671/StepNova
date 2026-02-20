package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    val backgroundColor by animateColorAsState(
        targetValue = if (goal.isSelected) OnboardingTheme.colors.selectedOptionBackground else StepNovaTheme.colors.surface,
        label = "background_color_animation"
    )
    val textColor by animateColorAsState(
        targetValue = if (goal.isSelected) OnboardingTheme.colors.selectedOptionText else StepNovaTheme.colors.textPrimary,
        label = "text_color_animation"
    )
    val borderColor by animateColorAsState(
        targetValue = if (goal.isSelected) OnboardingTheme.colors.selectedOptionBorder else Color.Transparent,
        label = "border_color_animation"
    )

    val shape = RoundedCornerShape(19.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(shape)
            .background(backgroundColor)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = shape
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
            color = textColor
        )

        AnimatedRoundedCheckbox(
            checked = goal.isSelected,
            onCheckedChange = { onClick(goal) }
        )
    }
}
