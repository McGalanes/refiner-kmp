package com.github.mcgalanes.refiner.presentation.feature.userstory.create

import androidx.lifecycle.ViewModel
import com.github.mcgalanes.refiner.domain.model.FormStep
import com.github.mcgalanes.refiner.domain.usecase.userstory.create.GetNextFormStep
import com.github.mcgalanes.refiner.domain.usecase.userstory.create.GetPreviousFormStep
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CreateUserStoryViewModel(
    private val getNextFormStep: GetNextFormStep,
    private val getPreviousFormStep: GetPreviousFormStep,
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState.Default)
    val uiState = _uiState.asStateFlow()

    fun onPersonaChange(persona: String) {
        _uiState.update { it.copy(persona = persona) }
    }

    fun onWishChange(wish: String) {
        _uiState.update { it.copy(wish = wish) }
    }

    fun onPurposeChange(purpose: String) {
        _uiState.update { it.copy(purpose = purpose) }
    }

    fun onSelectStep(step: FormStep) {
        _uiState.update { it.copy(selectedStep = step) }
    }

    fun onNextStepClick() {
        val currentStep = _uiState.value.selectedStep
        val newStep = getNextFormStep(currentStep) ?: return
        _uiState.update { it.copy(selectedStep = newStep) }
    }

    fun onPreviousStepClick() {
        val currentStep = _uiState.value.selectedStep
        val newStep = getPreviousFormStep(currentStep) ?: return
        _uiState.update { it.copy(selectedStep = newStep) }
    }
}
