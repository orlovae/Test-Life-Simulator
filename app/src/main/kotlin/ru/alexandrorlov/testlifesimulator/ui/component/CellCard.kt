package ru.alexandrorlov.testlifesimulator.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.testlifesimulator.R
import ru.alexandrorlov.testlifesimulator.ui.theme.ShapesLifeSimulator
import ru.alexandrorlov.testlifesimulator.ui.theme.TypographyLifeSimulator
import ru.alexandrorlov.testlifesimulator.utils.floatResource

@Composable
fun CellCard(
    cellType: CellType,
) {
    val shadow: Shadow? =
        when (cellType) {
            is CellType.Dead -> {
                Shadow(
                    color = colorResource(id = cellType.shadowTitle.color),
                    offset = Offset(
                        x = floatResource(id = cellType.shadowTitle.offsetX),
                        y = floatResource(id = cellType.shadowTitle.offsetY),
                    ),
                    blurRadius = floatResource(id = cellType.shadowTitle.blurRadius),
                )

            }
            else -> null
        }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.ShapesLifeSimulator.shapeCell,
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
        ),
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            IconCell(
                cellType = cellType,
            )

            Row {
                Column {
                    Text(
                        text = stringResource(id = cellType.title),
                        style = MaterialTheme.TypographyLifeSimulator.titleCell.copy(
                            shadow = shadow
                        ),
                    )

                    Text(
                        text = stringResource(id = cellType.note),
                        style = MaterialTheme.TypographyLifeSimulator.noteCell,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CellCardPreview() {
    val cellTypeList: List<CellType> = listOf(
        CellType.Dead(
            borderIcon = BorderIcon(),
            shadowTitle = ShadowTitle(),
        ),
        CellType.Alive(),
        CellType.Life,
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.small_padding)
        ),
    ){
        items(cellTypeList){ cell ->
            CellCard(cellType = cell)
        }
    }
}
