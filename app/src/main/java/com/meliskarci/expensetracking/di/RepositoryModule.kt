package com.meliskarci.expensetracking.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.meliskarci.expensetracking.data.remote.repository.FirebaseAuthImpl
import com.meliskarci.expensetracking.data.remote.repository.FirebaseDbImpl
import com.meliskarci.expensetracking.domain.usecase.auth.CurrentUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFirebaseAuthImpl(auth: FirebaseAuth) : FirebaseAuthImpl {
        return FirebaseAuthImpl(auth)
    }

     //FirebaseDbImpl için sağlanan fonksiyon
    @Singleton
    @Provides
    fun provideFirebaseDbImpl(database: FirebaseDatabase): FirebaseDbImpl {
        return FirebaseDbImpl(database)
    }
}