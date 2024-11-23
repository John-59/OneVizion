package com.john.projects.onevizion.usecases

import com.john.projects.core.backend.ItemsServiceApi
import com.john.projects.core.repository.ItemsRepositoryApi
import com.john.projects.core.utils.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Юзкейс кэширования объектов, получаемых от сервера.
 * Реализация самая элементарная, в реальных проектах тут придется решать проблемы синхронизации
 * изменений данных между локальным хранилищем и бэкендом.
 */
class CachingUseCase @Inject constructor(
    private val itemsService: ItemsServiceApi,
    private val repository: ItemsRepositoryApi,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
): UseCase<Unit, Result<Unit>>(coroutineDispatcher) {

    override suspend fun execute(params: Unit): Result<Unit> {
        return itemsService.getItems().map {
            repository.update(it)
        }
    }
}