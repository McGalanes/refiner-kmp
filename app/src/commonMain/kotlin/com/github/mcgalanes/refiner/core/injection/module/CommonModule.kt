package com.github.mcgalanes.refiner.core.injection.module

import AppViewModel
import com.github.mcgalanes.refiner.data.local.RefinerDatabase
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val commonModule = module {
    single { get<RefinerDatabase>().userStoryDao }
    viewModelOf(::AppViewModel)
}