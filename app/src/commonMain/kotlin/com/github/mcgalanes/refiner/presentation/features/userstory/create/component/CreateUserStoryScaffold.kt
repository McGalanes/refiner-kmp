package com.github.mcgalanes.refiner.presentation.features.userstory.create.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
internal fun CreateUserStoryScaffold(
    modifier: Modifier = Modifier,
    onUpNavigationClick: () -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(onUpNavigationClick = onUpNavigationClick)
        },
        bottomBar = {
            BottomBar(
                onNextClick = onNextClick,
                onBackClick = onBackClick,
            )
        },
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(top = 16.dp),
            shadowElevation = 4.dp,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        ) {
            content()
        }
    }
}
