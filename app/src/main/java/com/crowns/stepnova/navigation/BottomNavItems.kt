package com.crowns.stepnova.navigation

import com.crowns.stepnova.R

val bottomNavItems = listOf(
    BottomNavItem(
        "Activity",
        Activity,
        iconRes = R.drawable.ic_home_default,
        iconSelectRes = R.drawable.ic_home_solid,
        iconSelectDarkRes = R.drawable.ic_home_solid_dark
    ),
    BottomNavItem(
        "Nutrition",
        Nutrition,
        iconRes = R.drawable.ic_nutrition_default,
        iconSelectRes = R.drawable.ic_nutrition_solid,
        iconSelectDarkRes = R.drawable.ic_nutrition_solid_dark
    ),
    BottomNavItem(
        "Insights",
        Insights,
        iconRes = R.drawable.ic_steps_default,
        iconSelectRes = R.drawable.ic_steps_solid,
        iconSelectDarkRes = R.drawable.ic_steps_solid_dark
    ),
    BottomNavItem(
        "Account",
        Account,
        iconRes = R.drawable.ic_user_default,
        iconSelectRes = R.drawable.ic_user_solid,
        iconSelectDarkRes = R.drawable.ic_user_solid_dark
    )
)