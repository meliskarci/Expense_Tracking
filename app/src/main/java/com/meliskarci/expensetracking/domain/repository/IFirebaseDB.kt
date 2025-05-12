package com.meliskarci.expensetracking.domain.repository

import com.meliskarci.expensetracking.domain.model.Expense
import com.meliskarci.expensetracking.domain.model.ExpenseCategory
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface IFirebaseDB {
    fun getAllExpenses(userId: String): Flow<List<Expense>>
    suspend fun deleteExpense(expenseId: String)
    suspend fun addExpense(
        userId: String,
        title: String,
                           description: String,
                           amount: Double,
                           category: ExpenseCategory,
                           date: Date
    )
}