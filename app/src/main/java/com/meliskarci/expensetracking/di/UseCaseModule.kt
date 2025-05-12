package com.meliskarci.expensetracking.di


import com.meliskarci.expensetracking.data.remote.repository.FirebaseAuthImpl
import com.meliskarci.expensetracking.data.remote.repository.FirebaseDbImpl
import com.meliskarci.expensetracking.domain.usecase.auth.CurrentUserUseCase
import com.meliskarci.expensetracking.domain.usecase.auth.SignInWithEmailAndPasswordUseCase
import com.meliskarci.expensetracking.domain.usecase.auth.SignOutUseCase
import com.meliskarci.expensetracking.domain.usecase.auth.SignUpWithEmailAndPasswordUseCase
import com.meliskarci.expensetracking.domain.usecase.db.AddExpenseUseCase
import com.meliskarci.expensetracking.domain.usecase.db.DeleteExpenseUseCase
import com.meliskarci.expensetracking.domain.usecase.db.GetAllExpensesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSignInWithEmailAndPasswordUseCase(repository: FirebaseAuthImpl) : SignInWithEmailAndPasswordUseCase {
        return SignInWithEmailAndPasswordUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSignUpWithEmailAndPasswordUseCase(repository: FirebaseAuthImpl) : SignUpWithEmailAndPasswordUseCase {
        return SignUpWithEmailAndPasswordUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideSignOutUseCase(repository: FirebaseAuthImpl) : SignOutUseCase {
        return SignOutUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideCurrentUserUseCase(repository: FirebaseAuthImpl) : CurrentUserUseCase {
        return CurrentUserUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetAllExpensesUseCase(repository: FirebaseDbImpl) : GetAllExpensesUseCase {
        return GetAllExpensesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideDeleteExpenseUseCase(repository: FirebaseDbImpl) : DeleteExpenseUseCase {
        return DeleteExpenseUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideAddExpenseUseCase(repository: FirebaseDbImpl) : AddExpenseUseCase {
        return AddExpenseUseCase(repository)
    }



}