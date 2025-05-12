package com.meliskarci.expensetracking.domain.usecase.auth

import com.meliskarci.expensetracking.data.remote.repository.FirebaseAuthImpl
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val repo : FirebaseAuthImpl
) {
    suspend operator fun invoke(){
        repo.signOut()
    }
}