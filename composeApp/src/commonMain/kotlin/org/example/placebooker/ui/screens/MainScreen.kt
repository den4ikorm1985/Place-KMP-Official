package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.example.placebooker.core.resources.Res

class MainScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(title = { Text(Res.Strings.APP_NAME) })
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                // Поле поиска из твоего JSON
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(Res.Strings.SEARCH_PLACES) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Заглушка списка мест
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        Text(
                            text = "Здесь будет список мест из JSON...",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
