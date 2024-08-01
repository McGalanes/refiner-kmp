package com.github.mcgalanes.refiner.core.injection.module

import com.github.mcgalanes.refiner.data.local.RefinerDatabaseProvider
import org.koin.dsl.module

actual val platformModule = module {
    single { RefinerDatabaseProvider().getInstance() }
}