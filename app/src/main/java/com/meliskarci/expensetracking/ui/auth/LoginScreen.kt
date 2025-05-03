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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
//    val view //12
//    val isUser //14
//    val issucces //19
//    val mail = remember { mutableStateOf("") }
//    val password = remember { mutableStateOf("") }
//
//    lanchedeffect{
//
//    } //14
//
//    Column(modd) {
//
//        Button() {
//            is issuccess  //19
//            Text()
//        }
//        TextButton() {
//            Text()
//        }
//    }

    /////////////////////////  2 ///////////////////////////
    val viewmodel = hiltViewModel<AuthViewModel>() // 10
    val isUserAuthenticated = viewmodel.isAuthenticated.collectAsStateWithLifecycle() //10

    val mail = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    LaunchedEffect(isUserAuthenticated.value) {

        if (isUserAuthenticated.value) {
            navController.navigate(Screen.Home)
        }
    } //10


    Column(modifier = Modifier.fillMaxSize().padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login")
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mail.value,
            onValueChange = { mail.value = it },
            label = { Text("Mail") }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") }
        )
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewmodel.singIn(mail.value, password.value)
            }) {
            Text(text = "Login")
        }
        TextButton(
            onClick = { /* Navigate to RegisterScreen */
                navController.navigate(Screen.Register)
            }
        ) {
            Text(text = "Register")
        }
    }
}
/////////////////////////  2 ///////////////////////////