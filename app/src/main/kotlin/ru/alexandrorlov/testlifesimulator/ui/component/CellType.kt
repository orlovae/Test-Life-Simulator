package ru.alexandrorlov.testlifesimulator.ui.component

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import ru.alexandrorlov.testlifesimulator.R

@Immutable
sealed class CellType(
    @StringRes val title: Int,
    @StringRes val note: Int,
    @ColorRes val gradientStart: Int,
    @ColorRes val gradientEnd: Int,
    @StringRes val textIcon: Int,
) {
    data class Dead(
        val borderIcon: BorderIcon,
        val shadowTitle: ShadowTitle,
    ) : CellType(
        title = R.string.cell_dead_title,
        note = R.string.cell_dead_note,
        gradientStart = R.color.cellDeadStart,
        gradientEnd = R.color.cellAliveEnd,
        textIcon = R.string.cell_dead_icon_text,
    )

    data class Alive(
        val rotate: Float = 0f,
    ) : CellType(
        title = R.string.cell_alive_title,
        note = R.string.cell_alive_note,
        gradientStart = R.color.cellAliveStart,
        gradientEnd = R.color.cellAliveEnd,
        textIcon = R.string.cell_alive_icon_text,
    )

    data object Life : CellType(
        title = R.string.cell_life_title,
        note = R.string.cell_life_note,
        gradientStart = R.color.cellLifeStart,
        gradientEnd = R.color.cellLifeEnd,
        textIcon = R.string.cell_life_icon_text,
    )

    data object Init : CellType(
        title = R.string.cell_init,
        note = R.string.cell_init,
        gradientStart = R.color.transparent,
        gradientEnd = R.color.transparent,
        textIcon = R.string.cell_init,
    )
}

data class BorderIcon(
    @DimenRes
    val width: Int = R.dimen.border_thickness_icon_text,
    @ColorRes
    val color: Int = R.color.black,
)

data class ShadowTitle(
    @ColorRes
    val color: Int = R.color.black,
    @DimenRes
    val offsetX: Int = R.dimen.cell_dead_title_offset_x,
    @DimenRes
    val offsetY: Int = R.dimen.cell_dead_title_offset_y,
    @DimenRes
    val blurRadius: Int = R.dimen.cell_dead_title_blur_radius,
)
