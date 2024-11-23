package com.john.projects.services.repository

import com.john.projects.core.domain.Item
import com.john.projects.core.repository.ItemsRepositoryApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Некоторая конкретная реализация локального хранилища данных.
 * Пока просто заглушка.
 */
class ItemsRepositoryImpl @Inject constructor(): ItemsRepositoryApi {
    /**
     * Список всех объектов.
     */
    override val items: Flow<List<Item>>
        get() = flow {
            TODO("Not yet implemented")
        }

    /**
     * Получить детальную информацию об объекте по его идентификатору.
     * @param itemId идентификатор объекта.
     * @return информация об объекте.
     */
    override suspend fun getDetails(itemId: Long): Item {
        TODO("Not yet implemented")
    }

    /**
     * Обновление объектов в локальном репозитории.
     * @param items Список объектов.
     * @return Result.success если выполнение успешно, Result.failure если что-то пошло не так.
     */
    override suspend fun update(items: List<Item>): Result<Unit> {
        TODO("Not yet implemented")
    }
}