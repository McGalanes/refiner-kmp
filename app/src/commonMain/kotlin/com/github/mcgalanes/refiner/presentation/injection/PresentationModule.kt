package com.github.mcgalanes.refiner.presentation.injection

import com.github.mcgalanes.refiner.presentation.feature.userstory.create.CreateUserStoryViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::CreateUserStoryViewModel)
}