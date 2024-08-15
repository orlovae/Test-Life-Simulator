package ru.alexandrorlov.testlifesimulator.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.alexandrorlov.testlifesimulator.R
import ru.alexandrorlov.testlifesimulator.ui.component.CellCard
import ru.alexandrorlov.testlifesimulator.ui.component.CellType
import ru.alexandrorlov.testlifesimulator.ui.component.CreateButton
import ru.alexandrorlov.testlifesimulator.ui.component.TopBar
import ru.alexandrorlov.testlifesimulator.ui.theme.BackgroundEnd
import ru.alexandrorlov.testlifesimulator.ui.theme.BackgroundStart
import ru.alexandrorlov.testlifesimulator.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
){

    val state: State<List<CellType>> = viewModel.cellType.collectAsState()

    val cellList: List<CellType> = state.value

    val listState: LazyListState = rememberLazyListState()

    LaunchedEffect(cellList.size) {
        listState.scrollToItem(cellList.size)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TopBar(title = stringResource(id = R.string.main_topbar_title)) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            BackgroundStart,
                            BackgroundEnd,
                        ),
                    ),
                )
                .padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.medium_padding))
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.x_x_small_padding)),
                contentPadding = PaddingValues(vertical = dimensionResource(id = R.dimen.medium_padding)),
                state = listState,
            ) {
                val cellTypeList: List<CellType> = cellList

                items(cellTypeList) { cellType ->
                    CellCard(cellType = cellType)
                }
            }

            CreateButton(
                title = stringResource(id = R.string.button_text),
                onClick = {
                    viewModel.onClickCreateButton.tryEmit("onClick")
                },
            )
        }
    }
}
