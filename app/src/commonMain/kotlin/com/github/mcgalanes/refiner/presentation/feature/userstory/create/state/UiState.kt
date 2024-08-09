package com.github.mcgalanes.refiner.presentation.feature.userstory.create.state

import com.github.mcgalanes.refiner.domain.model.FormStep

data class UiState(
    val selectedStep: FormStep,
    val persona: String,
    val wish: String,
    val purpose: String,
    val kpi: String,
    val businessValue: Int?,
) {
    companion object {
        val Default =
            UiState(
                selectedStep = FormStep.Need,
                persona = "",
                wish = "",
                purpose = "",
                kpi = "",
                businessValue = 0,
            )
    }
}