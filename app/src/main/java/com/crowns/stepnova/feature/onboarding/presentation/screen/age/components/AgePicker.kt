package com.crowns.stepnova.feature.onboarding.presentation.screen.age.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.pulseOrange20
import com.crowns.stepnova.core.ui.theme.pulseOrange50
import com.crowns.stepnova.core.ui.theme.sandowGray100
import com.crowns.stepnova.core.ui.theme.sandowGray20
import com.crowns.stepnova.core.ui.theme.sandowGray40
import com.crowns.stepnova.core.ui.theme.sandowGray60
import com.crowns.stepnova.core.ui.theme.sandowGray80
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite
import com.crowns.stepnova.feature.onboarding.presentation.components.SelectableBorderContainer
import com.crowns.stepnova.feature.onboarding.ui.theme.OnboardingTheme
import kotlin.math.abs

@Composable
fun AgePicker(
    selectedAge: Int,
    onAgeSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isDark = isSystemInDarkTheme()
    val ages = (1..100).toList()

    val selectedItemHeightDp = 160.dp
    val unselectedItemHeightDp = 68.dp
    val visibleItems = 5

    val selectedColor = if (isDark) sandowGray100 else sandowGrayWhite
    val nearColor = if (isDark) sandowGray60 else sandowGray40
    val farColor = if (isDark) sandowGray80 else sandowGray20

    val componentHeight =
        selectedItemHeightDp + (unselectedItemHeightDp * (visibleItems - 1))

    val density = LocalDensity.current
    val componentHeightPx = with(density) { componentHeight.toPx() }
    val selectedItemHeightPx = with(density) { selectedItemHeightDp.toPx() }

    val initialIndex = (selectedAge - 1).coerceAtLeast(0)
    val initialScrollOffset =
        ((componentHeightPx - selectedItemHeightPx) / 2).toInt()

    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = initialIndex,
        initialFirstVisibleItemScrollOffset = initialScrollOffset
    )

    val haptics = LocalHapticFeedback.current

    var initialized by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        initialized = true
    }

    val centerIndex by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val visibleItemsInfo = layoutInfo.visibleItemsInfo
            if (visibleItemsInfo.isEmpty()) {
                initialIndex
            } else {
                val viewportCenter = layoutInfo.viewportSize.height / 2
                visibleItemsInfo.minByOrNull {
                    abs(it.offset + it.size / 2 - viewportCenter)
                }?.index ?: initialIndex
            }
        }
    }

    LaunchedEffect(selectedAge) {
        if (!initialized) return@LaunchedEffect
        val targetIndex = (selectedAge - 1).coerceAtLeast(0)
        if (centerIndex != targetIndex) {
            listState.animateScrollToItem(
                targetIndex,
                scrollOffset = initialScrollOffset
            )
        }
    }

    LaunchedEffect(listState.isScrollInProgress, centerIndex) {
        if (!listState.isScrollInProgress) {
            val newAge = ages[centerIndex]
            if (selectedAge != newAge) {
                onAgeSelected(newAge)
                haptics.performHapticFeedback(HapticFeedbackType.TextHandleMove)
            }
        }
    }

    LaunchedEffect(centerIndex) {
        if (listState.isScrollInProgress) {
            haptics.performHapticFeedback(HapticFeedbackType.LongPress)
        }
    }

    val snappingLayout = rememberSnapFlingBehavior(listState)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(componentHeight),
        contentAlignment = Alignment.Center
    ) {

        LazyColumn(
            state = listState,
            flingBehavior = snappingLayout,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            itemsIndexed(ages, key = { _, age -> age }) { index, age ->

                val diff = abs(index - centerIndex)
                val isSelected = index == centerIndex

                val textColor = when(diff) {
                    0 -> selectedColor
                    1 -> nearColor
                    else -> farColor
                }

                // 🔥 SIN animación en primer render
                val itemHeight = if (initialized) {
                    animateDpAsState(
                        targetValue = if (isSelected)
                            selectedItemHeightDp
                        else
                            unselectedItemHeightDp,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        ),
                        label = "itemHeight"
                    ).value
                } else {
                    if (isSelected) selectedItemHeightDp
                    else unselectedItemHeightDp
                }

                val alpha = if (initialized) {
                    animateFloatAsState(
                        targetValue = when (diff) {
                            0 -> 1f
                            1 -> 0.45f
                            2 -> 0.2f
                            else -> 0.08f
                        },
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        ),
                        label = "alpha"
                    ).value
                } else {
                    if (isSelected) 1f else 0.2f
                }

                val scale = if (initialized) {
                    animateFloatAsState(
                        targetValue = when (diff) {
                            0 -> 1f
                            1 -> 0.78f
                            else -> 0.62f
                        },
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        ),
                        label = "scale"
                    ).value
                } else {
                    if (isSelected) 1f else 0.7f
                }

                val fontSize = if (initialized) {
                    animateFloatAsState(
                        targetValue = if (isSelected) 128f else 60f,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        ),
                        label = "fontSize"
                    ).value
                } else {
                    if (isSelected) 128f else 60f
                }

                Box(
                    modifier = Modifier
                        .height(itemHeight)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    if (isSelected) {
                        SelectableBorderContainer(
                            isSelected = true,
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(itemHeight),
                            cornerRadius = 48.dp,
                            borderWidth = 4.dp,
                            selectedBackgroundColor = OnboardingTheme.colors.selectedRulerValue,
                            selectedBorderColor = OnboardingTheme.colors.selectedBorderRulerValue
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = age.toString(),
                                    fontSize = fontSize.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = textColor,
                                    modifier = Modifier.graphicsLayer {
                                        scaleX = scale
                                        scaleY = scale
                                        cameraDistance = 8f * density.density
                                    }
                                )
                            }
                        }
                    } else {
                        Text(
                            text = age.toString(),
                            fontSize = fontSize.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor,
                            modifier = Modifier.graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                cameraDistance = 8f * density.density
                            }
                        )
                    }
                }
            }
        }

        val gradientHeight =
            (componentHeight - selectedItemHeightDp) / 2
        val gradientStartColor =
            MaterialTheme.colorScheme.surface

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(gradientHeight)
                .align(Alignment.TopCenter)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(gradientHeight)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    StepNovaTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AgePicker(selectedAge = 25, onAgeSelected = {})
        }
    }
}

@Preview
@Composable
fun DarkPreview() {
    StepNovaTheme(darkTheme = true) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AgePicker(selectedAge = 25, onAgeSelected = {})
        }
    }
}