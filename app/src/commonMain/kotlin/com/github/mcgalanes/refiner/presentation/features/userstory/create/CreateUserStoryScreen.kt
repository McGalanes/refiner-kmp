package com.github.mcgalanes.refiner.presentation.features.userstory.create

import NeedForm
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
import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Step
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_need_title


@Composable
fun CreateUserStoryScreen(
    modifier: Modifier = Modifier,
) {
    val tipsProvider = koinInject<TipsProvider>()

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
                text = stringResource(Res.string.userstory_create_step_need_title),
                style = MaterialTheme.typography.headlineSmall,
            )

            VerticalSpacer(24.dp)

            NeedForm(
                persona = "developer",
                wish = "a nice user story",
                purpose = "to understand the user's needs",
                tips = tipsProvider(Step.Need),
                onPersonaChange = {},
                onWishChange = {},
                onPurposeChange = {},
            )

            VerticalSpacer(24.dp)
        }
    }
}
