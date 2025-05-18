package com.meliskarci.expensetracking.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.FirebaseDatabase
import com.meliskarci.expensetracking.domain.model.Expense
import com.meliskarci.expensetracking.domain.model.ExpenseCategory
import com.meliskarci.expensetracking.domain.usecase.auth.CurrentUserUseCase
import com.meliskarci.expensetracking.domain.usecase.db.AddExpenseUseCase
import com.meliskarci.expensetracking.utils.Constants.REFS_EXPENSES
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val db : FirebaseDatabase,
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

            val userId = currentUserUseCase().first()?.uid ?: return@launch
            val ref = db.reference.child(REFS_EXPENSES).push()
            val id = ref.key ?: return@launch

            val expense = Expense(
                id = id,
                userId = userId,
                title = title,
                description = description,
                amount = amount,
                category = category,
                date = date
            )

            ref.setValue(expense)
        }
    }
}