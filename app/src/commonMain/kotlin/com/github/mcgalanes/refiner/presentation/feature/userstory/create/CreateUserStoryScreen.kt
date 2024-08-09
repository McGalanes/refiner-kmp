package com.github.mcgalanes.refiner.presentation.feature.userstory.create

import KpiForm
import NeedForm
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.mcgalanes.refiner.core.design.component.spacer.VerticalSpacer
import com.github.mcgalanes.refiner.domain.model.FormStep
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.CreateUserStoryScaffold
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.state.UiState


@Composable
internal fun CreateUserStoryScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateUserStoryViewModel,
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    CreateUserStoryScreen(
        state = state,
        onUpNavigationClick = { TODO() },
        onSelectStep = viewModel::onSelectStep,
        onPersonaChange = viewModel::onPersonaChange,
        onWishChange = viewModel::onWishChange,
        onPurposeChange = viewModel::onPurposeChange,
        onKpiChange = viewModel::onKpiChange,
        onNextStepClick = viewModel::onNextStepClick,
        onPreviousStepClick = viewModel::onPreviousStepClick,
        modifier = modifier,
    )
}

@Composable
private fun CreateUserStoryScreen(
    state: UiState,
    onUpNavigationClick: () -> Unit,
    onSelectStep: (FormStep) -> Unit,
    onPersonaChange: (String) -> Unit,
    onWishChange: (String) -> Unit,
    onPurposeChange: (String) -> Unit,
    onKpiChange: (String) -> Unit,
    onNextStepClick: () -> Unit,
    onPreviousStepClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CreateUserStoryScaffold(
        modifier = modifier,
        selectedStep = state.selectedStep,
        onSelectStep = onSelectStep,
        onUpNavigationClick = onUpNavigationClick,
        onNextStepClick = onNextStepClick,
        onPreviousStepClick = onPreviousStepClick,
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            VerticalSpacer(24.dp)

            Crossfade(
                targetState = state.selectedStep,
                animationSpec = spring(),
            ) { selectedStep ->
                when (selectedStep) {
                    FormStep.Need -> {
                        NeedForm(
                            persona = state.persona,
                            wish = state.wish,
                            purpose = state.purpose,
                            onPersonaChange = onPersonaChange,
                            onWishChange = onWishChange,
                            onPurposeChange = onPurposeChange,
                        )
                    }

                    FormStep.Kpi -> {
                        KpiForm(
                            kpi = state.kpi,
                            onKpiChange = onKpiChange,
                        )
                    }

                    else -> {}
                }
            }

            VerticalSpacer(24.dp)
        }
    }
}
