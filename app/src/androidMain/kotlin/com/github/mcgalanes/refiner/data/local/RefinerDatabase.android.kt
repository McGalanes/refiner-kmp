package com.github.mcgalanes.refiner.data.local

import android.content.Context
import androidx.room.Room
import com.github.mcgalanes.refiner.data.local.RefinerDatabase.Companion.DATABASE_NAME

actual class RefinerDatabaseProvider(
    private val context: Context,
) {
    actual fun getInstance(): RefinerDatabase =
        Room.databaseBuilder(
            context = context,
            klass = RefinerDatabase::class.java,
            name = DATABASE_NAME,
        ).build()
}
