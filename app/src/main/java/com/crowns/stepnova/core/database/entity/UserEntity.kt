package com.crowns.stepnova.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.crowns.stepnova.feature.onboarding.domain.model.ActivityLevel
import com.crowns.stepnova.feature.onboarding.domain.model.FitnessGoal
import com.crowns.stepnova.feature.onboarding.domain.model.Gender

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val age: Int,
    val weight: Double,
    val height: Double,
    val gender: Gender,
    val activityLevel: ActivityLevel,
    val fitnessGoal: FitnessGoal,
    val targetWeight: Double?,
    val bodyFatPercentage: Double?,
    val createAt: Long
)