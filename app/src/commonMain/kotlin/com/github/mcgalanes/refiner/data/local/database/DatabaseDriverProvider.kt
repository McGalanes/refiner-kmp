package com.github.mcgalanes.refiner.data.local.database

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverProvider {
    operator fun invoke(): SqlDriver
}