package com.github.mcgalanes.refiner.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mcgalanes.refiner.domain.entity.UserStoryEntity

private const val TABLE_NAME = "criteria"

@Entity(tableName = TABLE_NAME)
data class Criteria(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long = -1,
    @ColumnInfo(COLUMN_NAME_USER_STORY_ID) val userStoryId: Long,
    @ColumnInfo(COLUMN_NAME_TITLE) val title: String,
) {
    companion object {
        internal const val COLUMN_NAME_ID = "id"
        internal const val COLUMN_NAME_USER_STORY_ID = "user_story_id"
        private const val COLUMN_NAME_TITLE = "title"
    }
}

fun Criteria.toDomainLayer(
    gherkinLines: List<UserStoryEntity.CriteriaEntity.GherkinLineEntity>,
): UserStoryEntity.CriteriaEntity =
    UserStoryEntity.CriteriaEntity(
        id = id,
        title = title,
        gherkinLines = gherkinLines,
    )

fun UserStoryEntity.CriteriaEntity.toData(userStoryId: Long): Criteria =
    Criteria(
        id = id,
        title = title,
        userStoryId = userStoryId,
    )
