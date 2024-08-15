package ru.alexandrorlov.testlifesimulator.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import ru.alexandrorlov.testlifesimulator.ui.component.BorderIcon
import ru.alexandrorlov.testlifesimulator.ui.component.CellType
import ru.alexandrorlov.testlifesimulator.ui.component.ShadowTitle
import ru.alexandrorlov.testlifesimulator.utils.Constant.COUNT_CELL_TYPE
import ru.alexandrorlov.testlifesimulator.utils.Constant.MAX_COUNT_CELL_TYPE_DEAD
import ru.alexandrorlov.testlifesimulator.utils.Constant.MAX_TYPE_CELL
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _cellType: MutableStateFlow<List<CellType>> = MutableStateFlow(emptyList())
    val cellType: StateFlow<List<CellType>> = _cellType.asStateFlow()

    val onClickCreateButton = MutableSharedFlow<Any>(extraBufferCapacity = 1)


    init {
        observeOnClickCreateButton()
    }

    private fun observeOnClickCreateButton() =
        onClickCreateButton
            .onEach {

                val randomIndex: Int = Random.nextInt(MAX_TYPE_CELL)

                val nextCellType: CellType = getNextCellType(randomIndex)

                updateState(nextCellType)
            }
            .launchIn(viewModelScope)

    private fun getNextCellType(randomIndex: Int): CellType =
        when(randomIndex) {
            0 -> CellType.Dead(BorderIcon(), ShadowTitle())
            1 -> CellType.Alive()
            else -> CellType.Init
        }

    private fun updateState(newCellType: CellType) =
        _cellType.update { list ->

            val mutableList: MutableList<CellType> = list.toMutableList()

            mutableList.add(newCellType)

            produceAddLife(mutableList)

            produceRemoveLife(mutableList)

            mutableList.toList()
        }

    private fun produceAddLife(list: MutableList<CellType>): List<CellType> {
        val isAddLife: Boolean = checkCountCellType(
            list = list,
            kClass = CellType.Alive()
        )

         if (isAddLife) {
            list.add(CellType.Life)
        }

        return list
    }

    private fun produceRemoveLife(list: MutableList<CellType>): List<CellType> {
        val isRemoveLife: Boolean = checkCountCellType(
            list = list,
            kClass = CellType.Dead(
                BorderIcon(),
                ShadowTitle(),
            ),
        )

        if (isRemoveLife && containsFirstCellLifeBeforeArrayCellDead(list)) {
            list.removeAt(list.size - MAX_COUNT_CELL_TYPE_DEAD)
        }

        return list
    }

    private inline fun <reified T> checkCountCellType(list: List<T>, kClass: T): Boolean =
        list
            .takeLast(COUNT_CELL_TYPE)
            .count {
                it!!::class.java == kClass!!::class.java
            }
            .let { count ->
                count == COUNT_CELL_TYPE
            }

    private fun containsFirstCellLifeBeforeArrayCellDead(list: List<CellType>): Boolean =
        list
            .takeLast(MAX_COUNT_CELL_TYPE_DEAD)
            .first()
            .let {
                it is CellType.Life
            }
}
