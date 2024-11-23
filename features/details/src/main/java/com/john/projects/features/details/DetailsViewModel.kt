package com.john.projects.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.john.projects.onevizion.usecases.GetItemDetailsUseCase
import com.john.projects.onevizion.usecases.UseCaseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Вьюмодель для экрана с информацией об объекте.
 * @param getItemDetailsUseCase Юзкейс получения информации об объекте.
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    getItemDetailsUseCase: GetItemDetailsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val args = DetailsArgs(savedStateHandle)

    /**
     * Информация об объекте.
     */
    val item = getItemDetailsUseCase(args.itemId)
        .stateIn(
            scope = viewModelScope,
            initialValue = UseCaseResult.Loading,
            started = SharingStarted.WhileSubscribed()
        )
}