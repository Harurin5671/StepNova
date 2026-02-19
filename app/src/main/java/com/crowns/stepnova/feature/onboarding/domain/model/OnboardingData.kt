package com.crowns.stepnova.feature.onboarding.domain.model

data class OnboardingData(
    val name: String,
    val age: Int,
    val weight: Double,
    val height: Double,
    val gender: Gender,
    val activityLevel: ActivityLevel,
    val fitnessGoal: FitnessGoal,
    val targetWeight: Double?,
    val notificationsEnabled: Boolean,
    val stepTrackingEnabled: Boolean
)