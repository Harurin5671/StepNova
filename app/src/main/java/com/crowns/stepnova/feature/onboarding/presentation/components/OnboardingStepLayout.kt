package com.crowns.stepnova.feature.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crowns.stepnova.R
import com.crowns.stepnova.core.ui.components.PrimaryActionButton
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.core.ui.theme.sandowGrayWhite
import com.crowns.stepnova.feature.onboarding.presentation.navigation.OnboardingNavState
import com.crowns.stepnova.feature.onboarding.ui.theme.OnboardingTheme

@Composable
fun OnboardingStepLayout(
    title: String,
    onNextClick: () -> Unit,
    navState: OnboardingNavState,
    content: @Composable () -> Unit,
) {
    val onboardingColors = OnboardingTheme.colors
    Scaffold(
        topBar = { OnboardingTopBar(navState = navState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(StepNovaTheme.colors.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                Text(
                    text = title,
                    color = StepNovaTheme.colors.textPrimary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(48.dp))

                content()
            }

            PrimaryActionButton(
                text = "Continue",
                onClick = onNextClick
            )

//            ElevatedButton(
//                onClick = onNextClick,
//                colors = ButtonDefaults.elevatedButtonColors(
//                    containerColor = onboardingColors.nextButton,
//                    contentColor = sandowGrayWhite
//                ),
//                shape = RoundedCornerShape(19.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(56.dp)
//                    .padding(top = 8.dp)
//            ) {
//                Text(
//                    "Continue",
//                    fontWeight = FontWeight.SemiBold,
//                    style = MaterialTheme.typography.titleMedium
//                )
//                Spacer(modifier = Modifier.width(12.dp))
//                Image(
//                    painterResource(id = R.drawable.ic_arrow_right),
//                    contentDescription = "Next Button",
//                    colorFilter = ColorFilter.tint(sandowGrayWhite)
//                )
//            }
        }
    }
}

@Preview
@Composable
fun Light() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme() {
        OnboardingStepLayout(
            title = "Prueba",
            onNextClick = {},
            navState = navState
        ) {
        }
    }
}

@Preview
@Composable
fun Dark() {
    val navState = OnboardingNavState(
        canGoBack = true,
        currentStep = 1,
        totalSteps = 3,
        onBackClick = {}
    )

    StepNovaTheme(darkTheme = true) {
        OnboardingStepLayout(
            title = "Prueba",
            onNextClick = {},
            navState = navState
        ) {
        }
    }
}