package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class MapScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(topBar = { @OptIn(ExperimentalMaterial3Api::class) TopAppBar(title = { Text("Карта") }, navigationIcon = { IconButton(onClick = { navigator.pop() }) { Icon(Icons.Default.ArrowBack, null) } }) }) { p -> Box(Modifier.padding(p)) { Text("Карта Пойковского") } }
    }
}