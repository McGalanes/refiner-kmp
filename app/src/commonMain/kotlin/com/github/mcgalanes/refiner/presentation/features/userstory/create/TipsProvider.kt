package com.github.mcgalanes.refiner.presentation.features.userstory.create

import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Step
import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Tips
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_need_tips_1_description
import refiner.app.generated.resources.userstory_create_step_need_tips_1_title
import refiner.app.generated.resources.userstory_create_step_need_tips_2_description
import refiner.app.generated.resources.userstory_create_step_need_tips_2_title
import refiner.app.generated.resources.userstory_create_step_need_tips_3_description
import refiner.app.generated.resources.userstory_create_step_need_tips_3_title

interface TipsProvider {
    operator fun invoke(step: Step): List<Tips>

    class Default : TipsProvider {
        override fun invoke(step: Step): List<Tips> =
            when (step) {
                Step.Need -> listOf(
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
                )

                else -> throw NotImplementedError()
            }
    }
}