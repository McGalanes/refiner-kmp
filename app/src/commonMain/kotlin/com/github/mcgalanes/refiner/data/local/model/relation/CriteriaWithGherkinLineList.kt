package com.github.mcgalanes.refiner.data.local.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.github.mcgalanes.refiner.data.local.model.Criteria
import com.github.mcgalanes.refiner.data.local.model.GherkinLine

data class CriteriaWithGherkinLineList(
    @Embedded val criteria: Criteria,
    @Relation(
        parentColumn = Criteria.COLUMN_NAME_ID,
        entityColumn = GherkinLine.COLUMN_NAME_CRITERIA_ID,
    )
    val gherkinLineList: List<GherkinLine>,
)
