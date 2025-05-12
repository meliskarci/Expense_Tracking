package com.meliskarci.expensetracking.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.FirebaseDatabase
import com.meliskarci.expensetracking.domain.model.Expense
import com.meliskarci.expensetracking.domain.model.ExpenseCategory
import com.meliskarci.expensetracking.domain.usecase.auth.CurrentUserUseCase
import com.meliskarci.expensetracking.domain.usecase.db.AddExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val addExpenseUseCase: AddExpenseUseCase,
    private val currentUserUseCase: CurrentUserUseCase
) :ViewModel(){

    fun addExpense(
        title: String,
        description: String,
        amount: Double,
        category: ExpenseCategory,
        date: Date
    ) {
        viewModelScope.launch {
            val currentUser = currentUserUseCase().first() ?: return@launch
            val userId = currentUser.uid
            addExpenseUseCase(userId,title, description, amount, category, date)
        }
    }
}