package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.crowns.stepnova.R
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.tabataBlue60
import com.crowns.stepnova.feature.onboarding.presentation.navigation.FitnessGoal
import com.crowns.stepnova.feature.onboarding.presentation.navigation.Gender

private val onboardingSteps = listOf(
    FitnessGoal,
    Gender
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingTopBar(
    backStack: NavBackStack<NavKey>
) {
    val canGoBack = backStack.size > 1
    val currentKey = backStack.lastOrNull()
    val currentStepIndex = onboardingSteps.indexOf(currentKey)
    val totalSteps = onboardingSteps.size
    val showStep = currentStepIndex != -1

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(
                text = "Assessment",
                color = StepNovaTheme.colors.textPrimary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 12.dp)
            )
        },
        navigationIcon = {
            if (canGoBack) {
                Box(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .background(
                            color = StepNovaTheme.colors.onboardingNavigationIcon,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .clickable {
                            backStack.removeLastOrNull()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_chevrom_left),
                        colorFilter = ColorFilter.tint(StepNovaTheme.colors.textPrimary),
                        contentDescription = "Back Button"
                    )
                }
            }
        },
        actions = {
            if (showStep) {
                Box(
                    modifier = Modifier
                        .width(66.dp)
                        .height(32.dp)
                        .background(
                            color = StepNovaTheme.colors.onboardingTagContainer,
                            shape = RoundedCornerShape(11.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${currentStepIndex + 1} of $totalSteps",
                        color = tabataBlue60,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    )
}