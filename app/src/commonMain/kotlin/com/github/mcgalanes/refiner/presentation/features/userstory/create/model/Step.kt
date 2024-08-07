package com.github.mcgalanes.refiner.presentation.features.userstory.create.model

import org.jetbrains.compose.resources.StringResource
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_assets
import refiner.app.generated.resources.userstory_create_step_business_value
import refiner.app.generated.resources.userstory_create_step_enablers
import refiner.app.generated.resources.userstory_create_step_kpi
import refiner.app.generated.resources.userstory_create_step_need
import refiner.app.generated.resources.userstory_create_step_solution
import refiner.app.generated.resources.userstory_create_step_uat

enum class Step(val title: StringResource) {
    Need(Res.string.userstory_create_step_need),
    Kpi(Res.string.userstory_create_step_kpi),
    BusinessValue(Res.string.userstory_create_step_business_value),
    Solution(Res.string.userstory_create_step_solution),
    Enablers(Res.string.userstory_create_step_enablers),
    Assets(Res.string.userstory_create_step_assets),
    Uat(Res.string.userstory_create_step_uat),
}
