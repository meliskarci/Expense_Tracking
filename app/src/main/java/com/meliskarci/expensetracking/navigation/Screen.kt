package com.meliskarci.expensetracking.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Auth : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object Detail : Screen

    @Serializable
    data object Settings : Screen

    @Serializable
    data object Tracking : Screen

    @Serializable
    data object Register : Screen /////  9

    @Serializable
    data object Login : Screen /////  11

    // 31 list screen
}