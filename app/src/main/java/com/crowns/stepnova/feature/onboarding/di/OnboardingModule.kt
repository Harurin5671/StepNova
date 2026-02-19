package com.crowns.stepnova.feature.onboarding.di

import com.crowns.stepnova.feature.onboarding.data.repository.OnboardingRepositoryImpl
import com.crowns.stepnova.feature.onboarding.domain.repository.OnboardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class OnboardingModule {

    @Binds
    abstract fun bindOnboardingRepository(
        onboardingRepositoryImpl: OnboardingRepositoryImpl
    ): OnboardingRepository
}
