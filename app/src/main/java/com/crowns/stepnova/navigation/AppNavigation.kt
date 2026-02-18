package com.crowns.stepnova.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.crowns.stepnova.core.ui.components.StepNovaBottomBar
import com.crowns.stepnova.core.ui.theme.StepNovaTheme
import com.crowns.stepnova.feature.account.presentation.AccountScreen
import com.crowns.stepnova.feature.activity.presentation.ActivityScreen
import com.crowns.stepnova.feature.insights.presentation.InsightsScreen
import com.crowns.stepnova.feature.nutrition.presentation.NutritionScreen

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Activity)

    Scaffold(
        bottomBar = { StepNovaBottomBar(backStack = backStack) },
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            entryProvider = entryProvider {
                entry<Activity> { ActivityScreen() }
                entry<Nutrition> { NutritionScreen() }
                entry<Insights> { InsightsScreen() }
                entry<Account> { AccountScreen() }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    StepNovaTheme {
        AppNavigation()
    }
}