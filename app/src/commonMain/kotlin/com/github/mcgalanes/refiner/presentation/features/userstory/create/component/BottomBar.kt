package com.github.mcgalanes.refiner.presentation.features.userstory.create.component

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
internal fun BottomBar(
    modifier: Modifier = Modifier,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Surface(modifier) {
        Column {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                strokeCap = StrokeCap.Square,
                progress = { .5f },
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
                    onClick = onBackClick,
                ) {
                    Text("Back")
                }

                Button(
                    modifier = Modifier.height(48.dp),
                    onClick = onNextClick,
                    shape = MaterialTheme.shapes.small,
                ) {
                    Text("Next")
                }
            }
        }
    }
}
