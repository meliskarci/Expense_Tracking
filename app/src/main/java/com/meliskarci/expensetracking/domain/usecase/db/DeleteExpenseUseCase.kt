package com.meliskarci.expensetracking.domain.usecase.db

import com.meliskarci.expensetracking.data.remote.repository.FirebaseDbImpl
import javax.inject.Inject

class DeleteExpenseUseCase @Inject constructor(
    private val repository: FirebaseDbImpl
) {
    suspend operator fun invoke(expenseId: String)  {
        repository.deleteExpense(expenseId)
    }
}