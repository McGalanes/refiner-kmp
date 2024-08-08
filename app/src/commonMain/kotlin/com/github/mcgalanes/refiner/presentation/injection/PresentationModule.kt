package com.github.mcgalanes.refiner.presentation.injection

import AppViewModel
import com.github.mcgalanes.refiner.presentation.features.userstory.create.TipsProvider
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    single<TipsProvider> { TipsProvider.Default() }
    viewModelOf(::AppViewModel)
}