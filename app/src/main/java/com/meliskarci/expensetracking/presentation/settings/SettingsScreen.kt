package com.meliskarci.expensetracking.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material.icons.outlined.CurrencyExchange
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.meliskarci.expensetracking.navigation.Screen
import com.meliskarci.expensetracking.presentation.settings.components.SettingsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<SettingsViewModel>()

    var darkMode = viewModel.isDarkMode.collectAsStateWithLifecycle()
    var selectedCurrency by remember { mutableStateOf("TRY") }
    var showLogoutDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        // Account Settings Section
        Text(
            text = "Hesap",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Change Password
        SettingsItem(
            icon = Icons.Outlined.Lock,
            title = "Şifre Değiştir",
            subtitle = "Hesap şifrenizi güncelleyin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Edit Profile
        SettingsItem(
            icon = Icons.Outlined.Person,
            title = "Profili Düzenle",
            subtitle = "Kişisel bilgilerinizi güncelleyin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Logout
        SettingsItem(
            icon = Icons.Outlined.Logout,
            title = "Oturumu Kapat",
            subtitle = "Hesabınızdan çıkış yapın",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { showLogoutDialog = true }
        )

        // App Settings Section
        Text(
            text = "Uygulama",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Theme Settings
        SettingsItem(
            icon = Icons.Outlined.DarkMode,
            title = "Karanlık Mod",
            subtitle = "Uygulamayı karanlık temada kullan",
            trailingContent = {
                Switch(
                    checked = darkMode.value,
                    onCheckedChange = {
                        viewModel.setDarkMode(it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            }
        )

        // Currency Settings
        SettingsItem(
            icon = Icons.Outlined.CurrencyExchange,
            title = "Para Birimi",
            subtitle = selectedCurrency,
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Notifications Section
        Text(
            text = "Bildirimler",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        SettingsItem(
            icon = Icons.Outlined.Notifications,
            title = "Bildirim Ayarları",
            subtitle = "Bildirim tercihlerinizi yönetin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Data Management Section
        Text(
            text = "Veri Yönetimi",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Export Data
        SettingsItem(
            icon = Icons.Outlined.Download,
            title = "Verileri Dışa Aktar",
            subtitle = "Harcama verilerinizi yedekleyin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Import Data
        SettingsItem(
            icon = Icons.Outlined.Upload,
            title = "Verileri İçe Aktar",
            subtitle = "Yedeklenen verilerinizi geri yükleyin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Clear Data
        SettingsItem(
            icon = Icons.Outlined.Delete,
            title = "Verileri Temizle",
            subtitle = "Tüm harcama verilerinizi silin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // About Section
        Text(
            text = "Hakkında",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // App Version
        SettingsItem(
            icon = Icons.Outlined.Android,
            title = "Uygulama Versiyonu",
            subtitle = "1.0.0",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Privacy Policy
        SettingsItem(
            icon = Icons.Outlined.PrivacyTip,
            title = "Gizlilik Politikası",
            subtitle = "Gizlilik politikamızı görüntüleyin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        // Terms of Use
        SettingsItem(
            icon = Icons.Outlined.Description,
            title = "Kullanım Koşulları",
            subtitle = "Kullanım koşullarını görüntüleyin",
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            },
            onClick = { /* TODO */ }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Oturumu Kapat") },
            text = { Text("Oturumunuzu kapatmak istediğinizden emin misiniz?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        navController.navigate(Screen.Login) {
                            popUpTo(Screen.Home) { inclusive = true }
                        }
                    }
                ) {
                    Text("Evet")
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text("İptal")
                }
            }
        )
    }
}