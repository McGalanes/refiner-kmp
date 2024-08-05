package com.github.mcgalanes.refiner.core.design.token

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal val DarkColorScheme =
    darkColorScheme(
        primary = Green80,
        onPrimary = DarkGreen10,
        primaryContainer = Green10,
        onPrimaryContainer = Color.White,
        inversePrimary = Green40,
        secondary = Blue80,
        onSecondary = Blue20,
        secondaryContainer = Blue10,
        onSecondaryContainer = Color.White,
        tertiary = Blue80,
        onTertiary = Blue20,
        tertiaryContainer = Blue30,
        onTertiaryContainer = Blue90,
        error = Red80,
        onError = Red20,
        errorContainer = Red30,
        onErrorContainer = Red90,
        background = Grey10,
        onBackground = Grey90,
        surface = Grey10,
        onSurface = Grey90,
        inverseSurface = Grey90,
        inverseOnSurface = Grey10,
        surfaceVariant = GreenGrey30,
        onSurfaceVariant = GreenGrey80,
        outline = GreenGrey80,
    )

internal val LightColorScheme =
    lightColorScheme(
        primary = Green20,
        onPrimary = Color.White,
        primaryContainer = Green30,
        onPrimaryContainer = Color.White,
        inversePrimary = Green80,
        secondary = Blue40,
        onSecondary = Color.White,
        secondaryContainer = Blue20,
        onSecondaryContainer = Blue90,
        tertiary = Blue40,
        onTertiary = Color.White,
        tertiaryContainer = Blue90,
        onTertiaryContainer = Blue10,
        error = Red40,
        onError = Color.White,
        errorContainer = Red90,
        onErrorContainer = Red10,
        background = Color.White,
        onBackground = Grey10,
        surface = Color.White,
        onSurface = Grey10,
        inverseSurface = Grey20,
        inverseOnSurface = Grey95,
        surfaceVariant = GreenGrey90,
        onSurfaceVariant = GreenGrey30,
        outline = GreenGrey50,
    )

@Composable
expect fun RefinerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
)
