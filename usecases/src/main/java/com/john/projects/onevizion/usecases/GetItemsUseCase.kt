package com.john.projects.onevizion.usecases

import com.john.projects.core.domain.Item
import com.john.projects.core.repository.ItemsRepositoryApi
import com.john.projects.core.utils.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 * Юзкейс получения всех объектов из локального репозитория.
 * @param itemsRepository Локальный репозиторий объектов.
 */
class GetItemsUseCase @Inject constructor(
    private val itemsRepository: ItemsRepositoryApi,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<Item>>(coroutineDispatcher) {

    override fun execute(params: Unit): Flow<UseCaseResult<List<Item>>> {
        return itemsRepository.items
            .map {
                UseCaseResult.Success(it) as UseCaseResult<List<Item>>
            }
            .onStart {
                emit(UseCaseResult.Loading)
            }
            .catch {
                emit(UseCaseResult.Error(it))
            }
    }
}