package com.crowns.stepnova.feature.onboarding.data.model

import java.time.LocalDate

data class UserProfile(
    val name: String = "",
    val gender: Gender = Gender.MALE,
    val birthDate: LocalDate = LocalDate.now(),
    val weight: Double = 0.0,
    val height: Double = 0.0,
    val weightUnit: WeightUnit = WeightUnit.KG,
    val heightUnit: HeightUnit = HeightUnit.CM,
    val goal: Goal = Goal.MAINTAIN,
    val activityLevel: ActivityLevel = ActivityLevel.MODERATE
)

enum class Gender { MALE, FEMALE }

enum class Goal {
    LOSE_WEIGHT, MAINTAIN, GAIN_MUSCLE
}

enum class ActivityLevel {
    SEDENTARY,      // poco o nada de ejercicio
    LIGHT,          // ejercicio ligero 1-3 días/semana
    MODERATE,       // ejercicio moderado 3-5 días/semana
    ACTIVE,         // ejercicio intenso 6-7 días/semana
    VERY_ACTIVE     // ejercicio muy intenso o trabajo físico
}

enum class WeightUnit { KG, LB }
enum class HeightUnit { CM, FT }