package com.crowns.stepnova.feature.onboarding.data.mapper

import com.crowns.stepnova.core.database.entity.UserEntity
import com.crowns.stepnova.feature.onboarding.domain.model.OnboardingData
import java.util.UUID

fun OnboardingData.toUserEntity(): UserEntity {
    return UserEntity(
        id = UUID.randomUUID().toString(),
        name = name,
        age = age,
        weight = weight,
        height = height,
        gender = gender,
        activityLevel = activityLevel,
        fitnessGoal = fitnessGoal,
        targetWeight = targetWeight,
        notificationsEnabled = notificationsEnabled,
        stepTrackingEnabled = stepTrackingEnabled,
        caloriesAtRest = null,
        dailyCaloriesBurned = null,
        dailyCalorieTarget = null,
        bodyFatPercentage = null,
        createAt = System.currentTimeMillis()
    )
}
