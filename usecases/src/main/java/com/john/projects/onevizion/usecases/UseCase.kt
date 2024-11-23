package com.john.projects.onevizion.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Базовый класс для юзкейсов.
 * @param P тип параметров юзкейса.
 * @param R тип данных успешного результата юзкейса.
 */
abstract class UseCase<in P, out R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(params: P): UseCaseResult<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(params).let {
                    UseCaseResult.Success(it)
                }
            }
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }

    protected abstract suspend fun execute(params: P): R
}