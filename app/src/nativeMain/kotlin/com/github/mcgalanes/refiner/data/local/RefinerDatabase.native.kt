package com.github.mcgalanes.refiner.data.local

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

actual class RefinerDatabaseProvider {
    actual fun getInstance(): RefinerDatabase {
        val dbFile = NSHomeDirectory() + "/people.db"
        return Room.databaseBuilder<RefinerDatabase>(
            name = dbFile,
            factory = { RefinerDatabase::class.instantiateImpl() }
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}
