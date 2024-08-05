package com.github.mcgalanes.refiner.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.github.mcgalanes.refiner.database.RefinerDatabase
import com.github.mcgalanes.refiner.database.UserStory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

interface UserStoryDao {
    fun getAllUserStories(): Flow<List<UserStory>>
    fun createUserStory(userStory: UserStory)
    fun deleteAllUserStories()
    fun deleteUserStory(id: Long)

    class Default(database: RefinerDatabase) : UserStoryDao {
        private val userStoryQueries = database.userStoryQueries
        private val criteriaQueries = database.criteriaQueries
        private val gherkinLineQueries = database.gherkineLineQueries

        override fun getAllUserStories(): Flow<List<UserStory>> =
            userStoryQueries.selectAll().asFlow().mapToList(Dispatchers.IO)

        override fun createUserStory(userStory: UserStory) {
            userStoryQueries.insert(
                id = userStory.id,
                title = "US n° ${userStory.id}",
                persona = userStory.persona,
                wish = userStory.wish,
                purpose = userStory.purpose,
                kpi = userStory.kpi,
                businessValue = userStory.businessValue,
                solution = userStory.solution,
                enablers = userStory.enablers,
                assets = userStory.assets,
                estimation = userStory.estimation,
                smallEnough = userStory.smallEnough,
                independent = userStory.independent,
                estimable = userStory.estimable,
                testable = userStory.testable,
            )
        }

        override fun deleteAllUserStories() {
            userStoryQueries.selectAll()
                .executeAsList()
                .forEach { deleteUserStory(it.id) }
        }

        override fun deleteUserStory(id: Long) {
            //TODO: delete criteria and gherkin lines
            userStoryQueries.deleteById(id)
        }
    }
}
