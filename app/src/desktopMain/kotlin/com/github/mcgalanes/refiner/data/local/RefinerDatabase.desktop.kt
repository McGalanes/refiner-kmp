package com.github.mcgalanes.refiner.data.local

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual class RefinerDatabaseProvider {
    actual fun getInstance(): RefinerDatabase =
        Room.databaseBuilder<RefinerDatabase>(
            name = File(System.getProperty("java.io.tmpdir"), "refiner.db").absolutePath,
        )
            .setDriver(BundledSQLiteDriver())
            .build()
}