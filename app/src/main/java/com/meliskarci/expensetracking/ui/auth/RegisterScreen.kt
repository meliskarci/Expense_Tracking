package com.meliskarci.expensetracking.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun RegisterScreen() {

//    val viewModel //7
//
//    is useraut //1*
//    val mail = remember { mutableStateOf("") }
//    val passwordConfirmation = remember { mutableStateOf("") }
//
////    launhhedeffect{
////        if (isUser
////            navcont)
////    } //10
//
//    Column(modd) {
//
//        Button() {
//            Text()
//        }
//    }


    val viewmodel = hiltViewModel<AuthViewModel>() ///////////////// 5 //////
//////////////////////////////////////////////////////////////  1   /////////////////////////////////////////////////////
    val mail = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordConfirmation = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Register")
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mail.value,
            onValueChange = { mail.value = it },
            label = { Text("Mail") }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passwordConfirmation.value,
            onValueChange = { passwordConfirmation.value = it },
            label = { Text("Password") }
        )
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {}) {
            Text(text = "Register")
        }
        TextButton(
            onClick = { /*Navigate to LoginScreen*/ }
        ) {
            Text(text = "Register")
        }
    }
}
/////////////////////////      1           /////////////////////////