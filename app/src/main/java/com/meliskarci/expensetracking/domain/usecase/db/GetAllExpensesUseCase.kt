package com.meliskarci.expensetracking.domain.usecase.db

import androidx.collection.emptyIntSet
import com.meliskarci.expensetracking.data.remote.repository.FirebaseDbImpl
import com.meliskarci.expensetracking.domain.model.Expense
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllExpensesUseCase @Inject constructor(
    private val repository: FirebaseDbImpl
) {
    operator fun invoke(userId: String): Flow<List<Expense>> {
        return repository.getAllExpenses(userId)
    }
}