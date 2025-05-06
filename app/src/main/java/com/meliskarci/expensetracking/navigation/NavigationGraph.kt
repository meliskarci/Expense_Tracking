package com.meliskarci.expensetracking.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meliskarci.expensetracking.presentation.auth.AuthScreen
import com.meliskarci.expensetracking.presentation.settings.SettingsScreen
import com.meliskarci.expensetracking.presentation.tracking.TrackingScreen
import com.meliskarci.expensetracking.presentation.add.AddScreen
import com.meliskarci.expensetracking.presentation.auth.LoginScreen
import com.meliskarci.expensetracking.presentation.auth.RegisterScreen
import com.meliskarci.expensetracking.presentation.list.ListScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Screen.Auth> {
            AuthScreen(navController)
        }
        composable<Screen.Home> {
            HomeScreen(navController)
        }
        composable<Screen.Settings> {
            SettingsScreen(navController)
        }
        composable<Screen.Tracking> {
            TrackingScreen()
        }
        composable<Screen.Add> {
            AddScreen(navController)
        }
        composable<Screen.Register> {
            RegisterScreen(navController)
        }
        composable<Screen.Login>{
            LoginScreen(navController)
        }
        composable<Screen.List>{
            ListScreen(navController)
        }
    }
}