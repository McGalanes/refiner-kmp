package com.github.mcgalanes.refiner.core.design.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

val TextStyle.highlight: TextStyle
    get() = this.copy(fontWeight = FontWeight.Bold)