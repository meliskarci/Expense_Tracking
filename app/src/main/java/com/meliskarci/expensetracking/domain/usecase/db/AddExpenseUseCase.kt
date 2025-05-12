package com.meliskarci.expensetracking.domain.usecase.db

import com.meliskarci.expensetracking.data.remote.repository.FirebaseDbImpl
import com.meliskarci.expensetracking.domain.model.ExpenseCategory
import java.util.Date
import javax.inject.Inject

class AddExpenseUseCase @Inject constructor(
    private val repository: FirebaseDbImpl
) {
    suspend operator fun invoke(
        userId: String,
        title: String,
        description: String,
        amount: Double,
        category: ExpenseCategory,
        date: Date)
    {
        repository.addExpense(userId, title, description, amount, category, date)
    }
}