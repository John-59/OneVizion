package com.john.projects.features.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.john.projects.onevizion.usecases.GetItemsUseCase
import com.john.projects.onevizion.usecases.UseCaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Вьюмодель для экрана со списком объектов.
 * @param getItemsUseCase Юзкейс получения всех объектов.
 */
@HiltViewModel
class ItemsViewModel @Inject constructor(
    getItemsUseCase: GetItemsUseCase,
): ViewModel() {

    /**
     * Список объектов.
     */
    val itemsResult = getItemsUseCase(Unit)
        .stateIn(
            scope = viewModelScope,
            initialValue = UseCaseResult.Loading,
            started = SharingStarted.WhileSubscribed()
        )
}