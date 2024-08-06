package com.github.mcgalanes.refiner.core.design.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
actual fun RefinerTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(if (darkTheme) Color.Transparent else Color.White)

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
