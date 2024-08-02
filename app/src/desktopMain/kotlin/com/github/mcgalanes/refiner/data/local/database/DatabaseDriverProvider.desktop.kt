package com.github.mcgalanes.refiner.data.local.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.github.mcgalanes.refiner.database.RefinerDatabase

actual class DatabaseDriverProvider {
    actual operator fun invoke(): SqlDriver {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        RefinerDatabase.Schema.create(driver)
        return driver
    }
}
