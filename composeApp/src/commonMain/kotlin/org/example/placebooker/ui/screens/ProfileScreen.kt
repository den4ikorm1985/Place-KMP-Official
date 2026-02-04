package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class ProfileScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(
                    title = { Text("Мой профиль") },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) { Icon(Icons.Default.ArrowBack, null) }
                    }
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Default.AccountCircle, null, modifier = Modifier.size(80.dp), tint = MaterialTheme.colorScheme.primary)
                IconButton(onClick = { navigator.push(EditProfileScreen()) }) { Icon(androidx.compose.material.icons.Icons.Default.Edit, null) }; Text("Денис", style = MaterialTheme.typography.headlineSmall)
                
                Spacer(modifier = Modifier.height(32.dp))

                // Кнопка перехода к списку бронирований
                OutlinedButton(
                    onClick = { navigator.push(BookingsScreen()) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.List, null)
                    Spacer(Modifier.width(8.dp))
                    Text("Мои бронирования")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Кнопка выхода (красная)
                TextButton(
                    onClick = { navigator.popUntilRoot() },
                    colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Выйти из аккаунта")
                }
            }
        }
    }
}
