package com.crowns.stepnova.feature.onboarding.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crowns.stepnova.feature.onboarding.domain.model.ActivityLevel
import com.crowns.stepnova.feature.onboarding.domain.model.FitnessGoal
import com.crowns.stepnova.feature.onboarding.domain.model.Gender
import com.crowns.stepnova.feature.onboarding.domain.model.OnboardingData
import com.crowns.stepnova.feature.onboarding.domain.usecase.SaveOnboardingDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OnboardingState(
    val name: String = "",
    val age: String = "",
    val gender: Gender = Gender.MALE,
    val height: String = "",
    val weight: String = "",
    val activityLevel: ActivityLevel = ActivityLevel.SEDENTARY,
    val fitnessGoal: FitnessGoal = FitnessGoal.MAINTAIN_WEIGHT,
    val targetWeight: String = "",
)

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val saveOnboardingDataUseCase: SaveOnboardingDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingState())
    val uiState = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.update { it.copy(name = name) }
    }

    fun onAgeChange(age: String) {
        _uiState.update { it.copy(age = age) }
    }

    fun onGenderChange(gender: Gender) {
        _uiState.update { it.copy(gender = gender) }
    }

    fun onHeightChange(height: String) {
        _uiState.update { it.copy(height = height) }
    }

    fun onWeightChange(weight: String) {
        _uiState.update { it.copy(weight = weight) }
    }

    fun onActivityLevelChange(activityLevel: ActivityLevel) {
        _uiState.update { it.copy(activityLevel = activityLevel) }
    }

    fun onFitnessGoalChange(fitnessGoal: FitnessGoal) {
        _uiState.update { it.copy(fitnessGoal = fitnessGoal) }
    }

    fun saveOnboardingData() {
        viewModelScope.launch {
            val currentState = _uiState.value
            val onboardingData = OnboardingData(
                name = currentState.name,
                age = currentState.age.toIntOrNull() ?: 0,
                weight = currentState.weight.toDoubleOrNull() ?: 0.0,
                height = currentState.height.toDoubleOrNull() ?: 0.0,
                gender = currentState.gender,
                activityLevel = currentState.activityLevel,
                fitnessGoal = currentState.fitnessGoal,
                targetWeight = currentState.targetWeight.toDoubleOrNull(),
                notificationsEnabled = true, // TODO: Get from permission state
                stepTrackingEnabled = true // TODO: Get from permission state
            )
            saveOnboardingDataUseCase(onboardingData)
        }
    }
}
