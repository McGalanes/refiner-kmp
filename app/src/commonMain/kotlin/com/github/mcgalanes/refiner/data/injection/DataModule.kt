package com.github.mcgalanes.refiner.data.injection

import com.github.mcgalanes.refiner.data.local.UserStoryDao
import com.github.mcgalanes.refiner.data.local.database.DatabaseDriverProvider
import com.github.mcgalanes.refiner.database.RefinerDatabase
import org.koin.dsl.module

val dataModule = module {
    single { get<DatabaseDriverProvider>()() }
    single { RefinerDatabase(get()) }
    single<UserStoryDao> { UserStoryDao.Default(get()) }
}