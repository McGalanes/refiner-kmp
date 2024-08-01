package com.github.mcgalanes.refiner.data.local.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.github.mcgalanes.refiner.data.local.model.Criteria
import com.github.mcgalanes.refiner.data.local.model.UserStory

data class UserStoryWithCriterias(
    @Embedded val userStory: UserStory,
    @Relation(
        parentColumn = UserStory.COLUMN_NAME_ID,
        entityColumn = Criteria.COLUMN_NAME_USER_STORY_ID,
    )
    val criterias: List<Criteria>,
)
