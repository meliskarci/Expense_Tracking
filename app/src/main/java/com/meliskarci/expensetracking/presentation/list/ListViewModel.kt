package com.meliskarci.expensetracking.presentation.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.meliskarci.expensetracking.domain.model.Expense
import com.meliskarci.expensetracking.domain.usecase.auth.CurrentUserUseCase
import com.meliskarci.expensetracking.domain.usecase.db.DeleteExpenseUseCase
import com.meliskarci.expensetracking.domain.usecase.db.GetAllExpensesUseCase
import com.meliskarci.expensetracking.utils.Constants.REFS_EXPENSES
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class ListViewModel @Inject constructor(
    private val db : FirebaseDatabase,
    private val currentUserUseCase: CurrentUserUseCase
) : ViewModel() {

    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean>
        get() = _isAuthenticated.asStateFlow()

    private val _allExpense = MutableStateFlow<List<Expense>>(emptyList())
    val allExpense: StateFlow<List<Expense>>
        get() = _allExpense.asStateFlow()

    init {
        isUserAuthenticated()
        getAllExpense()
    }

    fun isUserAuthenticated(){
        viewModelScope.launch {
            val isActive = currentUserUseCase().first() != null
            _isAuthenticated.value = isActive
        }
    }

    private fun getAllExpense() {
        viewModelScope.launch {
            val userId = currentUserUseCase().first()?.uid ?: return@launch

            db.getReference(REFS_EXPENSES).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val expenses = mutableListOf<Expense>()

                    for (data in snapshot.children) {

                        val expense = data.getValue(Expense::class.java)

                        if (expense != null && expense.userId == userId) {
                            expenses.add(expense)
                        }
                    }
                    _allExpense.value = expenses
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Firebase", "Veri çekme iptal edildi: ${error.message}")
                }
            })
        }
    }

    fun deleteExpense(expenseId: String) {
        viewModelScope.launch {
            db.getReference(REFS_EXPENSES).child(expenseId).removeValue()
        }
    }
}