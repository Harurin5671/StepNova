package com.crowns.stepnova.feature.onboarding.presentation.screen.weight.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.tabataBlue20
import com.crowns.stepnova.core.ui.theme.tabataBlue60

@Composable
fun UnitToggle(
    isKg: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val pillOffset by animateFloatAsState(
        targetValue = if (isKg) 0f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "pill_slide"
    )

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(StepNovaTheme.colors.surface)
    ) {
        val pillWidth = maxWidth / 2

        Box(
            modifier = Modifier
                .width(pillWidth)
                .fillMaxHeight()
                .padding(4.dp)
                .offset(x = pillWidth * pillOffset)
                .clip(RoundedCornerShape(14.dp))
                .background(tabataBlue60)
                .border(
                    width = 1.dp,
                    color = tabataBlue20,
                    shape = RoundedCornerShape(14.dp)
                )
        )

        Row(modifier = Modifier.fillMaxSize()) {
            UnitOption(
                label = "kg",
                isSelected = isKg,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = { onToggle(true) }
            )
            UnitOption(
                label = "lbs",
                isSelected = !isKg,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = { onToggle(false) }
            )
        }
    }
}

@Composable
private fun UnitOption(
    label: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color(0xFF9E9E9E),
        animationSpec = tween(durationMillis = 200),
        label = "text_color_$label"
    )

    Box(
        modifier = modifier.clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
    }
}