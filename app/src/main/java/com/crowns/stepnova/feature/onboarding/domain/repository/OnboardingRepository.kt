package com.crowns.stepnova.feature.onboarding.domain.repository

import com.crowns.stepnova.feature.onboarding.domain.model.OnboardingData

interface OnboardingRepository {
    suspend fun saveOnboardingData(data: OnboardingData)
}
