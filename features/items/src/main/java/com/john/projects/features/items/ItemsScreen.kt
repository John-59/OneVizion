package com.john.projects.features.items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.john.projects.onevizion.usecases.UseCaseResult

/**
 * Экран со списком объектов. Пока просто заглушка.
 * @param navigateToDetails Колбэк для перехода на экран с детальной информацией об объекте.
 */
@Composable
fun ItemsScreen(
    navigateToDetails: (Long) -> Unit,
    viewModel: ItemsViewModel = hiltViewModel()
) {
    val itemsResult by viewModel.itemsResult.collectAsStateWithLifecycle()

    when (val result = itemsResult) {
        is UseCaseResult.Error -> {
            // Выводим информацию об ошибке
        }
        UseCaseResult.Loading -> {
            // Показываем вейтер пока идет загрузка
        }
        is UseCaseResult.Success -> {
            val items = result.data
            // Рисуем полученный список с помощью, например, LazyColumn
            // При клике на конкретном объекте вызываем навигацию к экрану с детальной информацией
            // об объекте на котором кликнули - navigateToDetails(item.id)
        }
    }
}