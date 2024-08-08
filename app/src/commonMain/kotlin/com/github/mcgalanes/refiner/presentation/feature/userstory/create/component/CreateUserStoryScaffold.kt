package com.github.mcgalanes.refiner.presentation.feature.userstory.create.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.domain.model.FormStep


@Composable
internal fun CreateUserStoryScaffold(
    selectedStep: FormStep,
    modifier: Modifier = Modifier,
    onUpNavigationClick: () -> Unit,
    onSelectStep: (FormStep) -> Unit,
    onNextStepClick: () -> Unit,
    onPreviousStepClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                selectedStep = selectedStep,
                onSelectStep = onSelectStep,
                onUpNavigationClick = onUpNavigationClick
            )
        },
        bottomBar = {
            BottomBar(
                onNextClick = onNextStepClick,
                onBackClick = onPreviousStepClick,
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp),
            shadowElevation = 4.dp,
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp
            ),
        ) {
            content()
        }
    }
}
