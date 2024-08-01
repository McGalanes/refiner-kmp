package com.github.mcgalanes.refiner.domain.entity

data class UserStoryEntity(
    val id: Long,
    val title: String,
    val persona: String,
    val wish: String,
    val purpose: String,
    val kpi: String,
    val businessValue: Int,
    val solution: String,
    val enablers: String,
    val assets: String,
    val estimation: Int,
    val smallEnough: Boolean,
    val independent: Boolean,
    val estimable: Boolean,
    val testable: Boolean,
    val criterias: List<CriteriaEntity>,
) {
    data class CriteriaEntity(
        val id: Long,
        val title: String,
        val gherkinLines: List<GherkinLineEntity>,
    ) {
        data class GherkinLineEntity(
            val id: Long,
            val key: GherkinKeyEntity,
            val value: String,
        ) {
            enum class GherkinKeyEntity {
                Given,
                When,
                Then,
                And,
            }
        }
    }
}
