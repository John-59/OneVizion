package com.john.projects.onevizion.usecases

/**
 * Результат выполнения юзкейса.
 */
sealed class UseCaseResult<out T> {
    /**
     * Юзкейс успешно выполнен.
     * @param data Результат выполнения.
     */
    data class Success<out T>(val data: T) : UseCaseResult<T>()

    /**
     * Ошибка при выполнении юзкейса.
     */
    data class Error(val exception: Throwable) : UseCaseResult<Nothing>()

    /**
     * Юзкейс выполняется.
     */
    data object Loading: UseCaseResult<Nothing>()
}