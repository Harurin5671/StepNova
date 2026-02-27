package com.crowns.stepnova.feature.onboarding.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.R
import com.crowns.stepnova.core.ui.components.PrimaryActionButton
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.pulseOrange10
import com.crowns.stepnova.core.ui.theme.pulseOrange100
import com.crowns.stepnova.core.ui.theme.pulseOrange50
import com.crowns.stepnova.core.ui.theme.sandowGray100
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite
import com.crowns.stepnova.feature.onboarding.presentation.components.AnimatedRoundedCheckbox
import com.crowns.stepnova.feature.onboarding.presentation.components.OnboardingStepLayout
import com.crowns.stepnova.feature.onboarding.presentation.components.SelectableBorderContainer
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState

@Composable
fun GenderScreen(
    onNextClick: () -> Unit = {},
    navState: OnboardingNavState
) {
    OnboardingStepLayout(
        title = "What is your gender?",
        onNextClick = onNextClick,
        navState = navState
    ) {
        val isDark = isSystemInDarkTheme()

        val checkboxColor = if (isDark) sandowGrayWhite else sandowGray100

        val backgroundBtnColor = if (isDark) pulseOrange100 else pulseOrange10

        SelectableBorderContainer(
            cornerRadius = 40.dp,
            isSelected = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painterResource(R.drawable.male_gender_light),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier.fillMaxSize(),
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_gender_male), // tu ícono ♂
                        contentDescription = null
                    )
                    Text(
                        text = "Male",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                AnimatedRoundedCheckbox(
                    checked = false,
                    onCheckedChange = { /* seleccionar male */ },
                    selectedBorderColor = checkboxColor,
                    selectedInnerColor = checkboxColor,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        SelectableBorderContainer(
            cornerRadius = 32.dp,
            isSelected = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painterResource(R.drawable.female_gender_light),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier.fillMaxSize(),
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_gender_female), // tu ícono ♂
                        contentDescription = null
                    )
                    Text(
                        text = "Male",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                AnimatedRoundedCheckbox(
                    checked = true,
                    onCheckedChange = { /* seleccionar male */ },
                    selectedBorderColor = checkboxColor,
                    selectedInnerColor = checkboxColor,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
        PrimaryActionButton(
            text = "Prefer to skip, thanks!",
            onClick = {},
            containerColor = backgroundBtnColor,
            contentColor = pulseOrange50,
            iconRes = R.drawable.ic_close,
            iconTint = pulseOrange50
        )
    }
}

@Preview
@Composable
fun LightGender() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme {
        GenderScreen(
            navState = navState
        )
    }
}

@Preview
@Composable
fun DarkGender() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        GenderScreen(
            navState = navState
        )
    }
}