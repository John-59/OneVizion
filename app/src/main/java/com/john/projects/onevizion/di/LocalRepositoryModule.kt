package com.john.projects.onevizion.di

import com.john.projects.core.repository.ItemsRepositoryApi
import com.john.projects.services.repository.ItemsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DI для локального хранилища данных.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LocalRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindItemsRepository(impl: ItemsRepositoryImpl): ItemsRepositoryApi
}