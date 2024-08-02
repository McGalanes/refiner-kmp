package com.github.mcgalanes.refiner.data.local.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.github.mcgalanes.refiner.database.RefinerDatabase

actual class DatabaseDriverProvider {
    actual operator fun invoke(): SqlDriver {
        return NativeSqliteDriver(RefinerDatabase.Schema, "refiner.db")
    }
}
