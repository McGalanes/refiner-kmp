package com.github.mcgalanes.refiner.presentation.features.userstory.create.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.core.design.component.spacer.HorizontalSpacer
import com.github.mcgalanes.refiner.core.design.component.spacer.VerticalSpacer
import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Tips
import org.jetbrains.compose.resources.stringResource


@Composable
internal fun TipsBox(
    title: String,
    tips: List<Tips>,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Column(
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { expanded = !expanded },
                )
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                    )

                    HorizontalSpacer(8.dp)

                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                )
            }

            AnimatedVisibility(visible = expanded) {
                Column {
                    VerticalSpacer(24.dp)

                    tips.onEachIndexed { index, it ->
                        TipsLine(it)

                        if (index < tips.size) VerticalSpacer(16.dp)
                    }
                }
            }
        }
    }
}

@Composable
private fun TipsLine(
    tips: Tips,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(tips.title),
            style = MaterialTheme.typography.titleSmall,
        )

        VerticalSpacer(8.dp)

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = stringResource(tips.description),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
