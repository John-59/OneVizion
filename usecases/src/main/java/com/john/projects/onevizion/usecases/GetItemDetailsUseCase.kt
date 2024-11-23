package com.john.projects.onevizion.usecases

import com.john.projects.core.domain.Item
import com.john.projects.core.repository.ItemsRepositoryApi
import com.john.projects.core.utils.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Юзкейс получения детальной информации об объекте из локального репозитория.
 * @param itemsRepository Локальный репозиторий объектов.
 */
class GetItemDetailsUseCase @Inject constructor(
    private val itemsRepository: ItemsRepositoryApi,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher
): FlowUseCase<Long, Item>(coroutineDispatcher) {

    override fun execute(params: Long): Flow<UseCaseResult<Item>> {
        return flow {
            emit(UseCaseResult.Loading)
            runCatching {
                itemsRepository.getDetails(params)
            }.onSuccess {
                emit(UseCaseResult.Success(it))
            }.onFailure {
                emit(UseCaseResult.Error(it))
            }
        }
    }
}