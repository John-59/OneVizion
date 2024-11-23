package com.john.projects.services.backend

import com.john.projects.core.backend.ItemsServiceApi
import com.john.projects.core.domain.Item
import javax.inject.Inject

/**
 * Некоторая реализация работы с бэкендом.
 * Пока просто заглушка.
 */
class ItemsServiceImpl @Inject constructor(): ItemsServiceApi {

    /**
     * Список всех объектов.
     */
    override suspend fun getItems(): Result<List<Item>> {
        TODO("Not yet implemented")
    }
}