package com.meliskarci.expensetracking.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.meliskarci.expensetracking.navigation.Screen



@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = hiltViewModel<HomeViewModel>()
    val isUserAuthenticated = viewModel.isAuthenticated.collectAsStateWithLifecycle()
    val allExpenses = viewModel.allExpenses.collectAsStateWithLifecycle()

    LaunchedEffect(isUserAuthenticated.value) {
        if (!isUserAuthenticated.value){
            navController.navigate(Screen.Login)
        }
    }

    LazyColumn (Modifier.fillMaxSize()){
        items(allExpenses.value.size) {
            Card (modifier = Modifier.fillMaxWidth().padding(5.dp)){
                Text(text = allExpenses.value[it].title)
                Text(text = allExpenses.value[it].description)
                Text(text = allExpenses.value[it].amount.toString())
            }
        }
    }
}
 //////////12
