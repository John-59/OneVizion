package com.john.projects.features.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.john.projects.onevizion.usecases.UseCaseResult

/**
 * Эран с информацией об объекте. Пока просто заглушка.
 */
@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val itemResult by viewModel.item.collectAsStateWithLifecycle()

    when (val result = itemResult) {
        is UseCaseResult.Error -> {
            // Выводим информацию об ошибке
        }
        UseCaseResult.Loading -> {
            // Показываем вейтер пока идет загрузка
        }
        is UseCaseResult.Success -> {
            val item = result.data
            // Выводим на экран информацию об элементе
        }
    }
}