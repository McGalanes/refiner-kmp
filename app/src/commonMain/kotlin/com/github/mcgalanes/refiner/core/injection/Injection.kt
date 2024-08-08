package com.github.mcgalanes.refiner.core.injection

import com.github.mcgalanes.refiner.core.injection.module.commonModule
import com.github.mcgalanes.refiner.core.injection.module.platformModule
import com.github.mcgalanes.refiner.data.injection.dataModule
import com.github.mcgalanes.refiner.domain.injection.domainModule
import com.github.mcgalanes.refiner.presentation.injection.presentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            commonModule,
            platformModule,
            dataModule,
            domainModule,
            presentationModule,
        )
    }
}