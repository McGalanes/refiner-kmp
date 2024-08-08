package com.github.mcgalanes.refiner.domain.usecase.userstory.create

import com.github.mcgalanes.refiner.domain.model.FormStep


fun interface GetPreviousFormStep {
    operator fun invoke(current: FormStep): FormStep?

    class Default : GetPreviousFormStep {
        override fun invoke(current: FormStep): FormStep? =
            FormStep.entries.getOrNull(current.ordinal - 1)
    }
}
