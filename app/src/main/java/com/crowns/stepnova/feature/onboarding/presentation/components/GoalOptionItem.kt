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
import androidx.compose.ui.unit.Dp
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


@Composable
fun SelectableBorderContainer(
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 19.dp,
    borderWidth: Dp = 2.dp,
    selectedBackgroundColor: Color? = null,
    unselectedBackgroundColor: Color = StepNovaTheme.colors.surface,
    selectedBorderColor: Color = OnboardingTheme.colors.selectedOptionBorder,
    unselectedBorderColor: Color = Color.Transparent,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val targetColor = if (isSelected) selectedBackgroundColor ?: unselectedBackgroundColor
    else unselectedBackgroundColor

    val backgroundColor by animateColorAsState(
        targetValue = targetColor,
        label = "background_color_animation"
    )
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) selectedBorderColor else unselectedBorderColor,
        label = "border_color_animation"
    )

    val shape = RoundedCornerShape(cornerRadius)

    val clickableModifier = if (onClick != null) Modifier.clickable { onClick() } else Modifier

    Row(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .border(width = borderWidth, color = borderColor, shape = shape)
            .then(clickableModifier),
        content = { content() }
    )
}