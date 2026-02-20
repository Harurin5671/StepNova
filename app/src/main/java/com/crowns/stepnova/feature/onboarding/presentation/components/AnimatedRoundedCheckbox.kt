package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite

@Composable
fun AnimatedRoundedCheckbox(
    checked: Boolean,
    onCheckedChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    val animatedScale by animateFloatAsState(
        targetValue = if (checked) 1f else 0f,
        animationSpec = tween(
            durationMillis = 220,
            easing = FastOutSlowInEasing
        ),
        label = "checkbox_inner_scale"
    )

    val borderColor by animateColorAsState(
        targetValue = if (checked) sandowGrayWhite else StepNovaTheme.colors.textPrimary,
        label = "border_color_anim"
    )

    Box(
        modifier = modifier
            .size(24.dp)
//            .clip(RoundedCornerShape(2.dp))
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onCheckedChange() },
        contentAlignment = Alignment.Center
    ) {

        // 🔹 Caja interna animada con espacio alrededor
        Box(
            modifier = Modifier
                .size(28.dp - 14.dp) // ← deja espacio interno
                .graphicsLayer {
                    scaleX = animatedScale
                    scaleY = animatedScale
                }
                .clip(RoundedCornerShape(4.dp))
                .background(sandowGrayWhite)
        )
    }
}