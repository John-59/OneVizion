package com.john.projects.features.details

import androidx.lifecycle.SavedStateHandle

/**
 * Аргументы навигации на экран с детальной информацией об объекте.
 * @param itemId Идентификатор объекта.
 */
class DetailsArgs(
    val itemId: Long
) {
    constructor(savedStateHandle: SavedStateHandle)
        : this(
            itemId = savedStateHandle.get<Long>(itemIdArgName) ?: -1
        )

    companion object {
        const val itemIdArgName = "itemId"
    }
}