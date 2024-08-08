package com.github.mcgalanes.refiner.presentation.features.userstory.create

import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Step
import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Tips
import kotlin.test.Test
import kotlin.test.assertEquals
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_need_tips_1_description
import refiner.app.generated.resources.userstory_create_step_need_tips_1_title
import refiner.app.generated.resources.userstory_create_step_need_tips_2_description
import refiner.app.generated.resources.userstory_create_step_need_tips_2_title
import refiner.app.generated.resources.userstory_create_step_need_tips_3_description
import refiner.app.generated.resources.userstory_create_step_need_tips_3_title

class TipsProviderTest {

    private val provider = TipsProvider.Default()

    @Test
    fun `should return right tips for Need step`() {
        // WHEN
        val actual = provider(Step.Need)

        // THEN
        assertEquals(
            listOf(
                Tips(
                    title = Res.string.userstory_create_step_need_tips_1_title,
                    description = Res.string.userstory_create_step_need_tips_1_description
                ),
                Tips(
                    title = Res.string.userstory_create_step_need_tips_2_title,
                    description = Res.string.userstory_create_step_need_tips_2_description
                ),
                Tips(
                    title = Res.string.userstory_create_step_need_tips_3_title,
                    description = Res.string.userstory_create_step_need_tips_3_description
                ),
            ),
            actual,
        )
    }
}