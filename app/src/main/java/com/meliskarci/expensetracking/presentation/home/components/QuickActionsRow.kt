package com.meliskarci.expensetracking.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Category
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.meliskarci.expensetracking.navigation.Screen

@Composable
fun QuickActionsRow(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        QuickActionButton(
            icon = Icons.Outlined.Analytics,
            text = "Raporlar",
            onClick = { navController.navigate(Screen.Tracking) }
        )
        QuickActionButton(
            icon = Icons.Outlined.Category,
            text = "Kategoriler",
            onClick = {  }
        )
    }
}

@Preview
@Composable
fun QuickActionsRowPreview() {
    QuickActionsRow()
}