package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite
import com.crowns.stepnova.feature.onboarding.domain.model.ActivityLevel
import com.crowns.stepnova.feature.onboarding.domain.model.FitnessGoal
import com.crowns.stepnova.feature.onboarding.presentation.components.GoalOptionList
import com.crowns.stepnova.feature.onboarding.presentation.components.GoalUiModel
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout


val options = listOf<GoalUiModel>(
    GoalUiModel(id = "1", title = "I wanna lose weight", isSelected = false),
    GoalUiModel(id = "2", title = "I wanna try AI Coach", isSelected = false),
    GoalUiModel(id = "3", title = "I wanna get bulks", isSelected = false),
    GoalUiModel(id = "4", "I wanna gain endurance", isSelected = false),
    GoalUiModel(id = "5", "Just trying out the app! \uD83D\uDC4D", isSelected = false)
)

@Composable
fun GoalsScreen(
    activityLevel: ActivityLevel,
    fitnessGoal: FitnessGoal,
    onActivityLevelChange: (ActivityLevel) -> Unit,
    onFitnessGoalChange: (FitnessGoal) -> Unit,
    onNextClick: () -> Unit
) {
    var checked by remember { mutableStateOf(false) }

    OnboardingStepLayout(
        onNextClick = {}
    ) {
        Text(
            "What’s your fitness goal/target?",
            color = StepNovaTheme.colors.textPrimary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(48.dp))

        GoalOptionList(
            goals = options,
        ) {}
    }
}

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

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    StepNovaTheme(darkTheme = false) {
        GoalsScreen(
            activityLevel = ActivityLevel.SEDENTARY,
            fitnessGoal = FitnessGoal.MAINTAIN_WEIGHT,
            onActivityLevelChange = {},
            onFitnessGoalChange = {},
            onNextClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    StepNovaTheme(darkTheme = true) {
        GoalsScreen(
            activityLevel = ActivityLevel.SEDENTARY,
            fitnessGoal = FitnessGoal.MAINTAIN_WEIGHT,
            onActivityLevelChange = {},
            onFitnessGoalChange = {},
            onNextClick = {}
        )
    }
}
