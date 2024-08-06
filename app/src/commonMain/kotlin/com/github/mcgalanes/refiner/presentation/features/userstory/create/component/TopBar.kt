@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.mcgalanes.refiner.presentation.features.userstory.create.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.presentation.features.userstory.create.model.Step


@Composable
internal fun TopBar(
    modifier: Modifier = Modifier,
    onUpNavigationClick: () -> Unit,
) {
    var selectedStep by remember { mutableStateOf(Step.entries[0]) }

    Surface(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 4.dp)
            .height(64.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onUpNavigationClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = null,
                )
            }

            Box(
                modifier = Modifier.weight(1f)
            ) {
                StepDropdownMenu(
                    modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Center),
                steps = Step.entries,
                selectedStep = selectedStep,
                onSelect = { selectedStep = it },
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                )
            }
        }
    }
}
