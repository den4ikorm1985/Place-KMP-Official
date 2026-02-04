package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class EditProfileScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var name by remember { mutableStateFlowOf("Денис") }
        Scaffold(topBar = { @OptIn(ExperimentalMaterial3Api::class) TopAppBar(title = { Text("Редактировать") }, navigationIcon = { IconButton(onClick = { navigator.pop() }) { Icon(Icons.Default.ArrowBack, null) } }) }) { p -> 
            Column(Modifier.padding(p).padding(16.dp)) {
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Имя") }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(16.dp))
                Button(onClick = { navigator.pop() }, modifier = Modifier.fillMaxWidth()) { Text("Сохранить") }
            }
        }
    }
}