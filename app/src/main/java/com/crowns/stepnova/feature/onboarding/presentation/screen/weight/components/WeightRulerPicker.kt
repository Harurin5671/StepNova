package com.crowns.stepnova.feature.onboarding.presentation.screen.weight.components

import android.view.HapticFeedbackConstants
import android.view.View
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.sandowGray20
import com.crowns.stepnova.core.ui.theme.sandowGray30
import com.crowns.stepnova.core.ui.theme.sandowGray40
import com.crowns.stepnova.core.ui.theme.sandowGray60
import com.crowns.stepnova.core.ui.theme.sandowGray70
import com.crowns.stepnova.core.ui.theme.sandowGray80
import com.crowns.stepnova.feature.onboarding.presentation.components.SelectableBorderContainer
import com.crowns.stepnova.feature.onboarding.ui.theme.OnboardingTheme
import kotlin.math.abs
import kotlin.math.roundToInt

@OptIn(ExperimentalTextApi::class)
@Composable
fun WeightRulerPicker(
    value: Float,
    onValueChange: (Float) -> Unit,
    unit: String = "kg",
    minValue: Float = 30f,
    maxValue: Float = 200f,
    rulerHeight: Dp = 140.dp
) {
    val isDark = isSystemInDarkTheme()
    val midTickColor = if(isDark) sandowGray70 else  sandowGray30
    val minorTickColor = if(isDark) sandowGray80 else sandowGray20
    val tickLabelColor = if(isDark) sandowGray40 else sandowGray60
    val unitColor = if(isDark) sandowGray40 else sandowGray60

    // Tick structure:
    //   pos 0           → integer  → NO tick drawn, orange bar represents this
    //   pos 5           → half     → 56.dp tall, 3.dp wide
    //   pos 1-4, 6-9    → minor    → 24.dp tall, 2.dp wide
    // Spacing: 8.dp between every tick → 1 integer = 80.dp
    val ticksPerUnit = 10
    val tickSpacingDp = 8.dp
    val barHalfWidthDp = 8.dp // bar is 16.dp wide → skip ticks within 8.dp of center

    val textMeasurer = rememberTextMeasurer()
    val view: View = LocalView.current

    val totalTicks = ((maxValue - minValue) * ticksPerUnit).roundToInt()
    val minOffsetDp = 0f
    val maxOffsetDp = totalTicks * tickSpacingDp.value

    var dragOffsetDp by remember(unit) {
        mutableFloatStateOf(
            ((value - minValue) * ticksPerUnit * tickSpacingDp.value)
                .coerceIn(minOffsetDp, maxOffsetDp)
        )
    }

    LaunchedEffect(value, unit) {
        dragOffsetDp = ((value - minValue) * ticksPerUnit * tickSpacingDp.value)
            .coerceIn(minOffsetDp, maxOffsetDp)
    }

    val currentValue = (minValue + (dragOffsetDp / tickSpacingDp.value) / ticksPerUnit)
        .coerceIn(minValue, maxValue)

    var lastHapticOffset by remember { mutableFloatStateOf(dragOffsetDp) }

    val animatedDisplayValue by animateFloatAsState(
        targetValue = currentValue,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label = "weightAnim"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = "%.2f".format(animatedDisplayValue),
                fontSize = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                color = StepNovaTheme.colors.textPrimary,
                lineHeight = 80.sp
            )
            Text(
                text = unit,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                color = unitColor,
                modifier = Modifier.padding(start = 4.dp, bottom = 14.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(rulerHeight),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(minValue, maxValue, tickSpacingDp, totalTicks) {
                        val tickSpacingPx = tickSpacingDp.toPx()
                        val minOffsetPx = 0f
                        val maxOffsetPx = totalTicks * tickSpacingPx
                        var dragOffsetPx = dragOffsetDp * density

                        detectHorizontalDragGestures(
                            onDragStart = {
                                dragOffsetPx = dragOffsetDp * density
                                lastHapticOffset = dragOffsetDp
                            }
                        ) { _, dragAmount ->
                            dragOffsetPx =
                                (dragOffsetPx - dragAmount).coerceIn(minOffsetPx, maxOffsetPx)
                            dragOffsetDp = dragOffsetPx / density

                            val newValue =
                                (minValue + (dragOffsetDp / tickSpacingDp.value) / ticksPerUnit)
                                    .coerceIn(minValue, maxValue)
                            onValueChange(newValue)

                            // Haptic every tick crossing
                            val ticksMoved =
                                abs(dragOffsetDp - lastHapticOffset) / tickSpacingDp.value
                            if (ticksMoved >= 1f) {
                                lastHapticOffset = dragOffsetDp
                                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                            }
                        }
                    }
            ) {
                val canvasW = size.width
                val canvasH = size.height
                val centerX = canvasW / 2f
                val midY = canvasH / 2f

                val tickSpacingPx = tickSpacingDp.toPx()
                val barHalfWidthPx = barHalfWidthDp.toPx()
                val dragOffsetPx = dragOffsetDp * density

                // Tick heights in px
                val minorTickHeightPx = 24.dp.toPx()
                val halfTickHeightPx = 56.dp.toPx()

                val visibleTicks = (canvasW / 2f / tickSpacingPx).toInt() + 6
                val centeredTick = (dragOffsetPx / tickSpacingPx).roundToInt()
                val startTick = (centeredTick - visibleTicks).coerceAtLeast(0)
                val endTick = (centeredTick + visibleTicks).coerceAtMost(totalTicks)
                val centerTickExact = dragOffsetPx / tickSpacingPx

                for (i in startTick..endTick) {
                    val tickX = centerX + (i - centerTickExact) * tickSpacingPx
                    val posInUnit = i % ticksPerUnit
                    val isInteger = posInUnit == 0
                    val isHalf = posInUnit == 5

                    // Vignette fade
                    val distFromCenter = abs(tickX - centerX)
                    val fadeStart = canvasW * 0.30f
                    val fadeEnd = canvasW * 0.50f
                    val alpha = when {
                        distFromCenter < fadeStart -> 1f
                        distFromCenter > fadeEnd -> 0f
                        else -> 1f - (distFromCenter - fadeStart) / (fadeEnd - fadeStart)
                    }

                    // Skip ticks under the orange bar
                    if (distFromCenter <= barHalfWidthPx) continue

                    // Integer and half ticks = same height (56dp), minor = 24dp
                    val tickHeight =
                        if (isInteger || isHalf) halfTickHeightPx else minorTickHeightPx
                    val strokeWidthPx = if (isInteger || isHalf) 3.dp.toPx() else 2.dp.toPx()
                    val tickColor = if (isInteger || isHalf) midTickColor else minorTickColor

                    drawLine(
                        color = tickColor.copy(alpha = alpha),
                        start = Offset(tickX, midY - tickHeight / 2),
                        end = Offset(tickX, midY + tickHeight / 2),
                        strokeWidth = strokeWidthPx,
                        cap = StrokeCap.Round
                    )

                    // Label below integer ticks
                    if (isInteger) {
                        val labelValue = minValue + i.toFloat() / ticksPerUnit
                        val distanceFromCenter = abs(i.toFloat() - centerTickExact)
                        if (distanceFromCenter >= 1.5f) {
                            val textLayoutResult = textMeasurer.measure(
                                text = labelValue.roundToInt().toString(),
                                style = TextStyle(
                                    color = tickLabelColor.copy(alpha = alpha),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center
                                )
                            )
                            drawText(
                                textLayoutResult,
                                topLeft = Offset(
                                    x = tickX - textLayoutResult.size.width / 2f,
                                    y = midY + halfTickHeightPx / 2 + 14.dp.toPx()
                                )
                            )
                        }
                    }
                }
            }

            SelectableBorderContainer(
                isSelected = true,
                modifier = Modifier
                    .width(16.dp)
                    .height(116.dp)
                    .graphicsLayer {
                        shadowElevation = 16.dp.toPx()
                        clip = false
                    },
                cornerRadius = 6.dp,
                borderWidth = 1.5.dp,
                selectedBackgroundColor = OnboardingTheme.colors.selectedRulerValue,
                selectedBorderColor = OnboardingTheme.colors.selectedBorderRulerValue,
            ) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    StepNovaTheme {
        WeightRulerPicker(
            value = 128f,
            onValueChange = {},
            unit = "kg",
            minValue = 100f,
            maxValue = 150f
        )
    }
}

@Preview
@Composable
fun DarkPreview() {
    StepNovaTheme(
        darkTheme = true
    ) {
        WeightRulerPicker(
            value = 128f,
            onValueChange = {},
            unit = "kg",
            minValue = 100f,
            maxValue = 150f
        )
    }
}
