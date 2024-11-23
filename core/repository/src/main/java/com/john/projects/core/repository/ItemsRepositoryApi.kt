package com.john.projects.core.repository

import com.john.projects.core.domain.Item
import kotlinx.coroutines.flow.Flow

/**
 * Интерфейс некоторого локального репозитория.
 * Предположим (хотя в задании это и не оговаривается), что в этом репозитории мы хотим хранить
 * наши объекты Item. Например, для кэширования ответов от сервера или для возможности
 * работы с объектами в оффлайн-режиме при отсутствии сети и последующей синхронизации с
 * сервером после появления сети.
 */
interface ItemsRepositoryApi {
    /**
     * Список всех объектов.
     */
    val items: Flow<List<Item>>

    /**
     * Получить детальную информацию об объекте по его идентификатору.
     * @param itemId идентификатор объекта.
     * @return информация об объекте.
     */
    suspend fun getDetails(itemId: Long): Item

    /**
     * Обновление объектов в локальном репозитории.
     * @param items Список объектов.
     * @return Result.success если выполнение успешно, Result.failure если что-то пошло не так.
     */
    suspend fun update(items: List<Item>): Result<Unit>
}