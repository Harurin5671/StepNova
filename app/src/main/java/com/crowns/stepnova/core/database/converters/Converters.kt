package com.crowns.stepnova.core.database.converters

import androidx.room.TypeConverter
import com.crowns.stepnova.feature.onboarding.domain.model.ActivityLevel
import com.crowns.stepnova.feature.onboarding.domain.model.FitnessGoal
import com.crowns.stepnova.feature.onboarding.domain.model.Gender

class Converters {

    // Gender
    @TypeConverter
    fun fromGender(value: Gender): String = value.name

    @TypeConverter
    fun toGender(value: String): Gender = Gender.valueOf(value)

    // Activity Level
    @TypeConverter
    fun fromActivityLevel(value: ActivityLevel): String = value.name

    @TypeConverter
    fun toActivityLevel(value: String): ActivityLevel =
        ActivityLevel.valueOf(value)

    // Fitness Goal
    @TypeConverter
    fun fromFitnessGoal(value: FitnessGoal): String = value.name

    @TypeConverter
    fun toFitnessGoal(value: String): FitnessGoal =
        FitnessGoal.valueOf(value)

}