package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class ProfileScreen : Screen {
    @Composable
    override fun Content() {
        var name by remember { mutableStateOf("Денис") }
        var phone by remember { mutableStateOf("+7...") }

        Column(Modifier.fillMaxSize().padding(16.dp)) {
            Text("Профиль заказчика", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Имя") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text("Телефон") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(20.dp))
            Button(onClick = { /* Save logic */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Сохранить изменения")
            }
        }
    }
}
