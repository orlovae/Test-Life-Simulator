package ru.alexandrorlov.testlifesimulator.ui.component

import androidx.annotation.ColorRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.testlifesimulator.R
import ru.alexandrorlov.testlifesimulator.ui.theme.TypographyLifeSimulator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    @ColorRes
    backgroundColor: Int = R.color.transparent,
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.TypographyLifeSimulator.titleTopbar,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = colorResource(id = backgroundColor),
            titleContentColor = Color.White,
            ),
    )
}

@Preview
@Composable
private fun TopBarPreview() {
    val title: String = stringResource(id = R.string.main_topbar_title)
    val backgroundColor = R.color.black

    TopBar(
        title = title,
        backgroundColor = backgroundColor,
    )
}