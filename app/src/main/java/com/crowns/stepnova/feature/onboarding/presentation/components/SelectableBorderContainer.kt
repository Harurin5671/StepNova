package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.onboarding.ui.theme.OnboardingTheme

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