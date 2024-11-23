package com.john.projects.onevizion.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Базовый класс для юзкейсов, которые возвращают результат в виде потока.
 * @param P тип параметров юзкейса.
 * @param R тип данных успешного результата юзкейса.
 */
abstract class FlowUseCase<in P, out R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke(params: P): Flow<UseCaseResult<R>> {
        return execute(params)
            .catch {
                emit(UseCaseResult.Error(it))
            }
            .flowOn(coroutineDispatcher)
    }

    /**
     * Выполнить юзкейс.
     * @param params Параметры юзкейса.
     * @return Результат выполнения юзкейса.
     */
    protected abstract fun execute(params: P): Flow<UseCaseResult<R>>
}