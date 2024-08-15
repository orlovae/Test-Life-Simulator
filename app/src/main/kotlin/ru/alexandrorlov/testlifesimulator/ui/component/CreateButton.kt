package ru.alexandrorlov.testlifesimulator.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.testlifesimulator.R
import ru.alexandrorlov.testlifesimulator.ui.theme.BackgroundComponent
import ru.alexandrorlov.testlifesimulator.ui.theme.ShapesLifeSimulator
import ru.alexandrorlov.testlifesimulator.ui.theme.TypographyLifeSimulator

@Composable
fun CreateButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Button(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = dimensionResource(id = R.dimen.medium_padding),
                end = dimensionResource(id = R.dimen.medium_padding),
                bottom = dimensionResource(id = R.dimen.medium_padding),
            ),
        shape = MaterialTheme.ShapesLifeSimulator.shapeButton,
        colors = ButtonColors(
            containerColor = BackgroundComponent,
            contentColor = Color.White,
            disabledContainerColor = Color.Unspecified,
            disabledContentColor = Color.Unspecified,
        ),
    ) {
        Text(
            text = title.uppercase(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(id = R.dimen.small_padding),
                ),
            textAlign = TextAlign.Center,
            style = MaterialTheme.TypographyLifeSimulator.textButton,
        )
    }
}

@Preview
@Composable
fun CreateButtonPreview() {
    CreateButton(
        onClick = {  },
        title = stringResource(R.string.button_text),
    )
}