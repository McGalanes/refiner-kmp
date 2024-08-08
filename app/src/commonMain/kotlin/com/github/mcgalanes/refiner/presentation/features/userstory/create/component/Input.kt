package com.github.mcgalanes.refiner.presentation.features.userstory.create.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
internal fun Input(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        modifier = modifier,
        placeholder = { Text(text = placeholder ?: "") },
        value = value,
        label = { Text(text = label) },
        singleLine = singleLine,
        shape = MaterialTheme.shapes.large,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange,
    )
}
