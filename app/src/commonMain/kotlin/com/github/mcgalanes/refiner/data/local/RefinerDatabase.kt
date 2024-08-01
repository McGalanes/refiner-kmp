package com.github.mcgalanes.refiner.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.mcgalanes.refiner.data.local.model.Criteria
import com.github.mcgalanes.refiner.data.local.model.GherkinLine
import com.github.mcgalanes.refiner.data.local.model.UserStory

@Database(
    entities = [
        UserStory::class,
        Criteria::class,
        GherkinLine::class,
    ],
    version = 1,
)
abstract class RefinerDatabase : RoomDatabase() {
    abstract val userStoryDao: UserStoryDao
}
