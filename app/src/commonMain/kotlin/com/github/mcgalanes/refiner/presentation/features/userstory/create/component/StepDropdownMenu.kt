@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.mcgalanes.refiner.presentation.features.userstory.create.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.core.design.component.spacer.HorizontalSpacer
import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Step
import org.jetbrains.compose.resources.stringResource


@Composable
internal fun StepDropdownMenu(
    steps: List<Step>,
    selectedStep: Step,
    modifier: Modifier = Modifier,
    onSelect: (Step) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        Surface(
            modifier = Modifier
                .defaultMinSize(
                    minHeight = 48.dp,
                    minWidth = 152.dp
                )
                .menuAnchor(MenuAnchorType.PrimaryNotEditable),
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.primaryContainer,
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(selectedStep.title),
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                HorizontalSpacer(4.dp)

                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            }
        }

        ExposedDropdownMenu(
            modifier = Modifier.exposedDropdownSize(),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            steps.forEach { step ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(step.title),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    },
                    onClick = {
                        onSelect(step)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}
