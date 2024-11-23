package com.john.projects.onevizion.di

import com.john.projects.core.backend.ItemsServiceApi
import com.john.projects.services.backend.ItemsServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * DI для сервисов бэкенда
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class BackendServicesModule {
    @Binds
    @Singleton
    abstract fun bindItemsService(impl: ItemsServiceImpl): ItemsServiceApi
}