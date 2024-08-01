package com.github.mcgalanes.refiner.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.github.mcgalanes.refiner.data.local.model.Criteria
import com.github.mcgalanes.refiner.data.local.model.GherkinLine
import com.github.mcgalanes.refiner.data.local.model.UserStory
import com.github.mcgalanes.refiner.data.local.model.relation.UserStoryWithCriterias
import kotlinx.coroutines.flow.Flow

@Dao
interface UserStoryDao {
    @Transaction
    @Query("SELECT * FROM `user_story`")
    fun getUserStoriesWithCriterias(): Flow<List<UserStoryWithCriterias>>

    @Transaction
    @Query("SELECT * FROM `user_story` WHERE id = :id")
    fun getUserStoryWithCriterias(id: Long): Flow<UserStoryWithCriterias>

    @Query("SELECT * FROM `gherkin_line` WHERE criteria_id = :id")
    suspend fun getGherkinLinesByCriteriaId(id: Long): List<GherkinLine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUserStory(userStory: UserStory): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCriteria(criteria: Criteria): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createGherkinLine(gherkinLine: GherkinLine): Long

    @Transaction
    @Query("DELETE FROM `user_story`")
    suspend fun deleteAllUserStories()
}
