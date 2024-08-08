package com.github.mcgalanes.refiner.domain.usecase.userstory.create

import com.github.mcgalanes.refiner.domain.model.FormStep


fun interface GetNextFormStep {
    operator fun invoke(current: FormStep): FormStep?

    class Default : GetNextFormStep {
        override fun invoke(current: FormStep): FormStep? =
            FormStep.entries.getOrNull(current.ordinal + 1)
    }
}
