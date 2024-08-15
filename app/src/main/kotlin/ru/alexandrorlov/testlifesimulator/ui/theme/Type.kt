package ru.alexandrorlov.testlifesimulator.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography()

data class TypographyLifeSimulator(
    val titleTopbar: TextStyle = TextStyle(
        fontFamily = RobotoMedium,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 28.sp,
    ),
    val textButton: TextStyle = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 14.sp,
        lineHeight = 15.sp,
        letterSpacing = 4.sp,
    ),
    val textIcon: TextStyle = TextStyle(
        fontFamily = RobotoMedium,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        lineHeight = 28.sp,
    ),
    val titleCell: TextStyle = TextStyle(
        fontFamily = RobotoMedium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-1).sp,
    ),
    val noteCell: TextStyle = TextStyle(
        fontFamily = RobotoRegular,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
)

val LocalTextStyle = staticCompositionLocalOf { TypographyLifeSimulator() }

val MaterialTheme.TypographyLifeSimulator
    @Composable
    @ReadOnlyComposable
    get() = LocalTextStyle.current