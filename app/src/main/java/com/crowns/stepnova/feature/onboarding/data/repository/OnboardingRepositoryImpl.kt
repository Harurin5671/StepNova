package com.crowns.stepnova.feature.onboarding.data.repository

import com.crowns.stepnova.core.database.dao.UserDao
import com.crowns.stepnova.feature.onboarding.data.mapper.toUserEntity
import com.crowns.stepnova.feature.onboarding.domain.model.OnboardingData
import com.crowns.stepnova.feature.onboarding.domain.repository.OnboardingRepository
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : OnboardingRepository {
    override suspend fun saveOnboardingData(data: OnboardingData) {
        userDao.insertUser(data.toUserEntity())
    }
}
