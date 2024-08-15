package ru.alexandrorlov.testlifesimulator.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class ShapesLifeSimulator(
    val shapeButton: Shape = RoundedCornerShape(
        size = 4.dp,
    ),

    val shapeCell: Shape = RoundedCornerShape(
        size = 8.dp,
    ),

    val shapeIcon: Shape = CircleShape,
)

val LocalShapes = staticCompositionLocalOf { ShapesLifeSimulator() }

val MaterialTheme.ShapesLifeSimulator
    @Composable
    @ReadOnlyComposable
    get() = LocalShapes.current
