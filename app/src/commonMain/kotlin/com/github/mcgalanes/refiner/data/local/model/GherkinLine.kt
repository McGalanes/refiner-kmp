package com.github.mcgalanes.refiner.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.mcgalanes.refiner.domain.entity.UserStoryEntity

private const val TABLE_NAME = "gherkin_line"

@Entity(tableName = TABLE_NAME)
data class GherkinLine(
    @ColumnInfo(COLUMN_NAME_ID) @PrimaryKey(autoGenerate = true) val id: Long = -1,
    @ColumnInfo(COLUMN_NAME_GHERKIN_KEY) val gherkinKey: GherkinKey,
    @ColumnInfo(COLUMN_NAME_VALUE) val value: String,
    @ColumnInfo(COLUMN_NAME_CRITERIA_ID) val criteriaId: Long,
) {
    enum class GherkinKey {
        Given,
        When,
        Then,
        And,
    }

    companion object {
        internal const val COLUMN_NAME_CRITERIA_ID = "criteria_id"
        private const val COLUMN_NAME_ID = "id"
        private const val COLUMN_NAME_GHERKIN_KEY = "gherkin_key"
        private const val COLUMN_NAME_VALUE = "value"
    }
}

fun GherkinLine.toDomainLayer(): UserStoryEntity.CriteriaEntity.GherkinLineEntity {
    return UserStoryEntity.CriteriaEntity.GherkinLineEntity(
        id = id,
        key = gherkinKey.toDomainLayer(),
        value = value,
    )
}

fun GherkinLine.GherkinKey.toDomainLayer(): UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity =
    when (this) {
        GherkinLine.GherkinKey.Given -> UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.Given
        GherkinLine.GherkinKey.When -> UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.When
        GherkinLine.GherkinKey.Then -> UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.Then
        GherkinLine.GherkinKey.And -> UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.And
    }

fun UserStoryEntity.CriteriaEntity.GherkinLineEntity.toData(criteriaId: Long): GherkinLine =
    GherkinLine(
        id = id,
        gherkinKey = key.toDataLayer(),
        value = value,
        criteriaId = criteriaId,
    )

fun UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.toDataLayer(): GherkinLine.GherkinKey =
    when (this) {
        UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.Given -> GherkinLine.GherkinKey.Given
        UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.When -> GherkinLine.GherkinKey.When
        UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.Then -> GherkinLine.GherkinKey.Then
        UserStoryEntity.CriteriaEntity.GherkinLineEntity.GherkinKeyEntity.And -> GherkinLine.GherkinKey.And
    }
