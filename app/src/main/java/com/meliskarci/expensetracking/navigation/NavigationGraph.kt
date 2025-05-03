package com.meliskarci.expensetracking.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meliskarci.expensetracking.navigation.Screen.Auth
import com.meliskarci.expensetracking.navigation.Screen.Home
import com.meliskarci.expensetracking.navigation.Screen.Detail
import com.meliskarci.expensetracking.navigation.Screen.Settings
import com.meliskarci.expensetracking.navigation.Screen.Tracking
import com.meliskarci.expensetracking.navigation.Screen.Add
import com.meliskarci.expensetracking.ui.auth.AuthScreen
import com.meliskarci.expensetracking.ui.home.HomeScreen
import com.meliskarci.expensetracking.ui.detail.DetailScreen
import com.meliskarci.expensetracking.ui.settings.SettingsScreen
import com.meliskarci.expensetracking.ui.tracking.TrackingScreen
import com.meliskarci.expensetracking.ui.tracking.TrackingViewModel
import com.meliskarci.expensetracking.ui.add.AddScreen
import com.meliskarci.expensetracking.ui.auth.LoginScreen
import com.meliskarci.expensetracking.ui.auth.RegisterScreen
import kotlinx.serialization.Serializable

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
        composable<Auth> {
            AuthScreen(navController)

        }
        composable<Home> {
            HomeScreen(navController)
        }
        composable<Detail> {
            DetailScreen(navController)
        }
        composable<Settings> {
            SettingsScreen(navController)
        }
        composable<Tracking> {
            TrackingScreen(navController)
        }
        composable<Add> {
            AddScreen(navController)
        }

        composable<Screen.Register> {
            RegisterScreen(navController) //9
        }
        composable<Screen.Login>{
            LoginScreen(navController)   // 11
        }


    }
}