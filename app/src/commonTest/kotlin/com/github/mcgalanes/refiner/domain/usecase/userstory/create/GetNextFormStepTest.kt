package com.github.mcgalanes.refiner.domain.usecase.userstory.create

import com.github.mcgalanes.refiner.domain.model.FormStep
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class GetNextFormStepTest {

    private val getNextFormStep = GetNextFormStep.Default()

    @Test
    fun `should return Kpi when current is Need`() {
        assertEquals(
            FormStep.Kpi,
            getNextFormStep(current = FormStep.Need)
        )
    }

    @Test
    fun `should return BusinessValue when current is Kpi`() {
        assertEquals(
            FormStep.BusinessValue,
            getNextFormStep(current = FormStep.Kpi)
        )
    }

    @Test
    fun `should return Solution when current is BusinessValue`() {
        assertEquals(
            FormStep.Solution,
            getNextFormStep(current = FormStep.BusinessValue)
        )
    }

    @Test
    fun `should return Assets when current is Solution`() {
        assertEquals(
            FormStep.Assets,
            getNextFormStep(current = FormStep.Solution)
        )
    }

    @Test
    fun `should return Uat when current is Assets`() {
        assertEquals(
            FormStep.Uat,
            getNextFormStep(current = FormStep.Assets)
        )
    }

    @Test
    fun `should return null when current is Uat`() {
        assertNull(getNextFormStep(current = FormStep.Uat))
    }
}
