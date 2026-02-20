package com.crowns.stepnova.feature.onboarding.domain.usecase

import com.crowns.stepnova.feature.onboarding.domain.model.OnboardingData
import com.crowns.stepnova.feature.onboarding.domain.repository.OnboardingRepository
import javax.inject.Inject

class SaveOnboardingDataUseCase @Inject constructor(
    private val repository: OnboardingRepository
) {
    suspend operator fun invoke(data: OnboardingData) {
        repository.saveOnboardingData(data)
    }
}
