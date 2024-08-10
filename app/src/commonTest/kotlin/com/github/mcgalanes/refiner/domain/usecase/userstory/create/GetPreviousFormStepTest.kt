package com.github.mcgalanes.refiner.domain.usecase.userstory.create

import com.github.mcgalanes.refiner.domain.model.FormStep
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GetPreviousFormStepTest {

    private val getPreviousFormStep = GetPreviousFormStep.Default()

    @Test
    fun `should return null when current is Need`() {
        assertNull(
            getPreviousFormStep(current = FormStep.Need)
        )
    }

    @Test
    fun `should return Need when current is Kpi`() {
        assertEquals(
            FormStep.Need,
            getPreviousFormStep(current = FormStep.Kpi)
        )
    }

    @Test
    fun `should return Kpi when current is BusinessValue`() {
        assertEquals(
            FormStep.Kpi,
            getPreviousFormStep(current = FormStep.BusinessValue)
        )
    }

    @Test
    fun `should return BusinessValue when current is Solution`() {
        assertEquals(
            FormStep.BusinessValue,
            getPreviousFormStep(current = FormStep.Solution)
        )
    }

    @Test
    fun `should return Solution when current is Assets`() {
        assertEquals(
            FormStep.Solution,
            getPreviousFormStep(current = FormStep.Assets)
        )
    }

    @Test
    fun `should return Assets when current is Uat`() {
        assertEquals(
            FormStep.Assets,
            getPreviousFormStep(current = FormStep.Uat)
        )
    }
}
