package ru.alexandrorlov.testlifesimulator.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.testlifesimulator.R
import ru.alexandrorlov.testlifesimulator.ui.theme.ShapesLifeSimulator
import ru.alexandrorlov.testlifesimulator.ui.theme.TypographyLifeSimulator

@Composable
fun IconCell(
    cellType: CellType,
) {

    val modifierDefault: Modifier =
        Modifier
            .padding(dimensionResource(id = R.dimen.medium_padding))
            .size(dimensionResource(id = R.dimen.size_icon))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = cellType.gradientStart),
                        colorResource(id = cellType.gradientEnd),
                    )
                ),
                shape = MaterialTheme.ShapesLifeSimulator.shapeIcon,
            )

    val modifier: Modifier =
        when(cellType) {
            is CellType.Dead -> {
                modifierDefault
                    .border(
                        width = dimensionResource(id = cellType.borderIcon.width),
                        color = colorResource(id = cellType.borderIcon.color),
                        shape = MaterialTheme.ShapesLifeSimulator.shapeIcon,
                    )
            }

            else -> modifierDefault
        }

    val modifierText: Modifier =
        when(cellType) {
            is CellType.Alive -> {
                Modifier
                    .rotate(
                        degrees = cellType.rotate,
                    )
                    .scale(
                        scaleX = -1f,
                        scaleY = -1f,
                    )
            }

            else -> Modifier
        }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = cellType.textIcon),
            modifier = modifierText,
            style = MaterialTheme.TypographyLifeSimulator.textIcon,
        )
    }
}

@Preview
@Composable
fun IconCellPreview() {
    val cellType: CellType = CellType.Dead(
        borderIcon = BorderIcon(),
        shadowTitle = ShadowTitle(),
    )

    IconCell(
        cellType = cellType,
    )
}