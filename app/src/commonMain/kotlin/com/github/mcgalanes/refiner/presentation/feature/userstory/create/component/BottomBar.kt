package com.github.mcgalanes.refiner.presentation.feature.userstory.create.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.domain.model.FormStep

@Composable
internal fun BottomBar(
    selectedStep: FormStep,
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    val haptic = LocalHapticFeedback.current
    val progress by animateFloatAsState(selectedStep.getProgress())

    Surface(modifier) {
        Column {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                strokeCap = StrokeCap.Square,
                progress = { progress },
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(84.dp)
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextButton(
                    modifier = Modifier.height(48.dp),
                    onClick = {
                        onBackClick()
                        haptic.perform()
                    },
                ) {
                    Text("Back")
                }

                Button(
                    modifier = Modifier.height(48.dp),
                    onClick = {
                        onNextClick()
                        haptic.perform()
                    },
                    shape = MaterialTheme.shapes.small,
                ) {
                    Text("Next")
                }
            }
        }
    }
}

private fun HapticFeedback.perform() {
    performHapticFeedback(HapticFeedbackType.LongPress)
}

private fun FormStep.getProgress(): Float =
    (ordinal + 1f) / FormStep.entries.size.toFloat()

