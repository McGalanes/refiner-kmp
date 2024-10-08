package com.github.mcgalanes.refiner.core.injection.module

import com.github.mcgalanes.refiner.data.local.database.DatabaseDriverProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::DatabaseDriverProvider)
}
