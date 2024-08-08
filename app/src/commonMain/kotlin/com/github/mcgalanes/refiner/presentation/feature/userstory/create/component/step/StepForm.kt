package com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.step

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.core.design.component.spacer.VerticalSpacer
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.TipsBox
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.model.Tips
import org.jetbrains.compose.resources.stringResource
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_tips_box_title


@Composable
internal fun StepForm(
    tips: List<Tips>,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        content()

        if (tips.isNotEmpty()) {
            VerticalSpacer(24.dp)

            TipsBox(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = stringResource(Res.string.userstory_create_tips_box_title),
                tips = tips,
            )
        }
    }
}
