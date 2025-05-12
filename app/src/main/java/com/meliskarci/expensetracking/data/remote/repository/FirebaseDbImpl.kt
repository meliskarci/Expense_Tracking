package com.meliskarci.expensetracking.data.remote.repository

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.meliskarci.expensetracking.domain.model.Expense
import com.meliskarci.expensetracking.domain.model.ExpenseCategory
import com.meliskarci.expensetracking.domain.repository.IFirebaseDB
import com.meliskarci.expensetracking.domain.usecase.auth.CurrentUserUseCase
import com.meliskarci.expensetracking.utils.Constants.REFS_EXPENSES
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

class FirebaseDbImpl @Inject constructor(
    private val db: FirebaseDatabase,
) : IFirebaseDB {
    override fun getAllExpenses(userId: String): Flow<List<Expense>> = callbackFlow {
        val ref = db.getReference(REFS_EXPENSES)

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val expenses = mutableListOf<Expense>()
                for (data in snapshot.children) {
                    val expense = data.getValue(Expense::class.java)
                    if (expense != null && expense.userId == userId) {
                        expenses.add(expense)
                    }
                }
                trySend(expenses).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Veri çekme iptal edildi: ${error.message}")
                close(error.toException())
            }
        }

        ref.addValueEventListener(listener)

        awaitClose { ref.removeEventListener(listener) }
    }



    override suspend fun deleteExpense(expenseId: String) {
        db.getReference(REFS_EXPENSES).child(expenseId).removeValue()
    }

    override suspend fun addExpense(
        userId: String,
        title: String,
        description: String,
        amount: Double,
        category: ExpenseCategory,
        date: Date
    )  {
        val ref = db.reference.child("expenses").push()
        val id = ref.key ?: return

        val expense = Expense(
            id = id,
            userId = userId,
            title = title,
            description = description,
            amount = amount,
            category = category,
            date = date
        )

        ref.setValue(expense).addOnCompleteListener {task ->
            if (task.isSuccessful){
                Log.d("Firebase", "Veri başarıyla eklendi")
            } else {
                Log.e("Firebase", "Veri eklenirken hata oluştu: ${task.exception}")
            }
        }
    }
}



