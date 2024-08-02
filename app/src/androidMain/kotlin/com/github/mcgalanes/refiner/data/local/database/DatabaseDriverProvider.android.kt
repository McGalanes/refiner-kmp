package com.github.mcgalanes.refiner.data.local.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.github.mcgalanes.refiner.database.RefinerDatabase

actual class DatabaseDriverProvider(
    private val context: Context
) {
    actual operator fun invoke(): SqlDriver {
        return AndroidSqliteDriver(RefinerDatabase.Schema, context, "refiner.db")
    }
}