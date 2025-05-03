package com.meliskarci.expensetracking.ui.auth

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

//////3
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth : FirebaseAuth
) : ViewModel() {

    fun singUp (email : String, password : String, passwordConfirmation : String) {
        if (password == passwordConfirmation) {
            auth.createUserWithEmailAndPassword(email, password)
        } else {
            //Show error message
            println("Passwords do not match")
        }
    }
} //////3

//    val isUserAuthenticated = MutableStateFlow(false)
//    val _isUser
//    get() //9
//
//    is succes //18
//
//    init {} //9
//
//
//}
//
//fun singIn //13
//auth.sign listener //18
//
//fun iis userAuthu ()
//val user
//isAuth = user//9

