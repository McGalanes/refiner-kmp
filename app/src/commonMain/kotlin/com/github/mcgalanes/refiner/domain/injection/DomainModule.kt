package com.github.mcgalanes.refiner.domain.injection

import com.github.mcgalanes.refiner.domain.usecase.userstory.create.GetNextFormStep
import com.github.mcgalanes.refiner.domain.usecase.userstory.create.GetPreviousFormStep
import org.koin.dsl.module

val domainModule = module {
    single<GetNextFormStep> { GetNextFormStep.Default() }
    single<GetPreviousFormStep> { GetPreviousFormStep.Default() }
}
