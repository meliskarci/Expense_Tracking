package com.meliskarci.expensetracking.di

import com.meliskarci.expensetracking.data.repository.MainRepositoryImpl
import com.meliskarci.expensetracking.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainRepository(repositoryImpl: MainRepositoryImpl): MainRepository
}