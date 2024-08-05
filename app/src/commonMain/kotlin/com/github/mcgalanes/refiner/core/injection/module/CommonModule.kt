package com.github.mcgalanes.refiner.core.injection.module

import AppViewModel
import com.github.mcgalanes.refiner.data.local.UserStoryDao
import com.github.mcgalanes.refiner.data.local.database.DatabaseDriverProvider
import com.github.mcgalanes.refiner.database.RefinerDatabase
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val commonModule = module {
    single { get<DatabaseDriverProvider>()() }
    single { RefinerDatabase(get()) }
    single<UserStoryDao> { UserStoryDao.Default(get()) }
    viewModelOf(::AppViewModel)
}