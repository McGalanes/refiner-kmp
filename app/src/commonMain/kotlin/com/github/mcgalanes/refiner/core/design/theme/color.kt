package com.github.mcgalanes.refiner.core.design.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val Green10 = Color(0xff003324)
val Green20 = Color(0xff006647)
val Green30 = Color(0xff00996b)
val Green40 = Color(0xff00cc8f)
val Green80 = Color(0xff99ffe0)
val Green90 = Color(0xffccfff0)

val DarkGreen10 = Color(0xff0d260d)
val DarkGreen20 = Color(0xff194d19)
val DarkGreen30 = Color(0xff267326)
val DarkGreen40 = Color(0xff339933)
val DarkGreen80 = Color(0xffb3e6b3)
val DarkGreen90 = Color(0xffd9f2d9)

val Blue10 = Color(0xff032930)
val Blue20 = Color(0xff07525f)
val Blue30 = Color(0xff0a7b8f)
val Blue40 = Color(0xff0da4bf)
val Blue80 = Color(0xffa0ebf8)
val Blue90 = Color(0xffcff5fc)

val Red10 = Color(0xFF410001)
val Red20 = Color(0xFF680003)
val Red30 = Color(0xFF930006)
val Red40 = Color(0xFFBA1B1B)
val Red80 = Color(0xFFFFB4A9)
val Red90 = Color(0xFFFFDAD4)

val Grey10 = Color(0xFF191C1D)
val Grey20 = Color(0xFF2D3132)
val Grey90 = Color(0xFFE0E3E3)
val Grey95 = Color(0xFFEFF1F1)
val Grey99 = Color(0xFFFBFDFD)

val GreenGrey30 = Color(0xFF376255)
val GreenGrey50 = Color(0xFF5ca38e)
val GreenGrey80 = Color(0xFFbedad2)
val GreenGrey90 = Color(0xFFdeede8)

val Color.dim1: Color
    @Composable get() = this.copy(alpha = .72f)

val Color.dim2: Color
    @Composable get() = this.copy(alpha = .56f)

val Color.dim3: Color
    @Composable get() = this.copy(alpha = .40f)

val Color.dim4: Color
    @Composable get() = this.copy(alpha = .16f)

val Color.dim5: Color
    @Composable get() = this.copy(alpha = .08f)

val Color.disabled: Color
    @Composable get() = this.dim3.compositeOver(MaterialTheme.colorScheme.surface)

