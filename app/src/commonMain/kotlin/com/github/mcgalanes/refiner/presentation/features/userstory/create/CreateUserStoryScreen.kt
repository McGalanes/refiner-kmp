package com.github.mcgalanes.refiner.presentation.features.userstory.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.core.design.component.spacer.VerticalSpacer
import com.github.mcgalanes.refiner.presentation.features.userstory.create.component.CreateUserStoryScaffold


@Composable
fun CreateUserStoryScreen(
    modifier: Modifier = Modifier
) {
    CreateUserStoryScaffold(
        modifier = modifier,
        onUpNavigationClick = {},
        onNextClick = {},
        onBackClick = {},
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            VerticalSpacer(24.dp)

            Text(
                text = "What's your need?",
                style = MaterialTheme.typography.headlineSmall,
            )

            VerticalSpacer(8.dp)

            Text(
                text = "You can change it anytime.",
                style = MaterialTheme.typography.bodyMedium,
            )

            VerticalSpacer(16.dp)

            (0..200).forEach { i ->
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "This is a criteria #$i",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}
