package com.github.mcgalanes.refiner.presentation.feature.userstory.create

import com.github.mcgalanes.refiner.domain.model.FormStep
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateUserStoryViewModelTest {

    @Test
    fun `on person change, should update it`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "persona"

        // WHEN
        viewModel.onPersonaChange(input)

        // THEN
        assertEquals(
            input,
            viewModel.uiState.value.persona,
        )
    }

    @Test
    fun `on wish change, should update it`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "wish"

        // WHEN
        viewModel.onWishChange(input)

        // THEN
        assertEquals(
            input,
            viewModel.uiState.value.wish,
        )
    }

    @Test
    fun `on purpose change, should update it`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "purpose"

        // WHEN
        viewModel.onPurposeChange(input)

        // THEN
        assertEquals(
            input,
            viewModel.uiState.value.purpose,
        )
    }

    @Test
    fun `on kpi change, should update it`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "kpi"

        // WHEN
        viewModel.onKpiChange(input)

        // THEN
        assertEquals(
            input,
            viewModel.uiState.value.kpi,
        )
    }

    @Test
    fun `on business value change, should update it`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "75"

        // WHEN
        viewModel.onBusinessValueChange(input)

        // THEN
        assertEquals(
            input.toInt(),
            viewModel.uiState.value.businessValue,
        )
    }

    @Test
    fun `on business value change, should set it to null if not an integer`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "hundred"

        // WHEN
        viewModel.onBusinessValueChange(input)

        // THEN
        assertEquals(
            null,
            viewModel.uiState.value.businessValue,
        )
    }

    @Test
    fun `on business value change, should set to 100 if greater`() {
        // GIVEN
        val viewModel = viewModel()
        val input = "101"

        // WHEN
        viewModel.onBusinessValueChange(input)

        // THEN
        assertEquals(
            100,
            viewModel.uiState.value.businessValue,
        )
    }

    @Test
    fun `on select step, should select it`() {
        // GIVEN
        val viewModel = viewModel()
        val step = FormStep.Uat

        // WHEN
        viewModel.onSelectStep(step)

        // THEN
        assertEquals(
            step,
            viewModel.uiState.value.selectedStep,
        )
    }

    @Test
    fun `on next step click, should select next step`() {
        // GIVEN
        val nextStep = FormStep.Uat
        val viewModel = viewModel(
            getNextFormStep = { nextStep },
        )

        // WHEN
        viewModel.onNextStepClick()

        // THEN
        assertEquals(
            nextStep,
            viewModel.uiState.value.selectedStep,
        )
    }

    @Test
    fun `on previous step click, should select previous step`() {
        // GIVEN
        val previousStep = FormStep.Kpi
        val viewModel = viewModel(
            getPreviousFormStep = { previousStep },
        )

        // WHEN
        viewModel.onPreviousStepClick()

        // THEN
        assertEquals(
            previousStep,
            viewModel.uiState.value.selectedStep,
        )
    }

    private fun viewModel(
        getNextFormStep: (FormStep) -> FormStep = { throw NotImplementedError() },
        getPreviousFormStep: (FormStep) -> FormStep = { throw NotImplementedError() },
    ): CreateUserStoryViewModel =
        CreateUserStoryViewModel(
            getNextFormStep = getNextFormStep,
            getPreviousFormStep = getPreviousFormStep,
        )
}
