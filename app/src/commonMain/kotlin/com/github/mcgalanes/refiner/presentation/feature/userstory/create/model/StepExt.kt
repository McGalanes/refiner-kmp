package com.github.mcgalanes.refiner.presentation.feature.userstory.create.model

import com.github.mcgalanes.refiner.domain.model.FormStep
import org.jetbrains.compose.resources.StringResource
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_assets
import refiner.app.generated.resources.userstory_create_step_business_value
import refiner.app.generated.resources.userstory_create_step_enablers
import refiner.app.generated.resources.userstory_create_step_kpi
import refiner.app.generated.resources.userstory_create_step_need
import refiner.app.generated.resources.userstory_create_step_solution
import refiner.app.generated.resources.userstory_create_step_uat

fun FormStep.getTitle(): StringResource = when (this) {
    FormStep.Need -> Res.string.userstory_create_step_need
    FormStep.Kpi -> Res.string.userstory_create_step_kpi
    FormStep.BusinessValue -> Res.string.userstory_create_step_business_value
    FormStep.Solution -> Res.string.userstory_create_step_solution
    FormStep.Enablers -> Res.string.userstory_create_step_enablers
    FormStep.Assets -> Res.string.userstory_create_step_assets
    FormStep.Uat -> Res.string.userstory_create_step_uat
}
