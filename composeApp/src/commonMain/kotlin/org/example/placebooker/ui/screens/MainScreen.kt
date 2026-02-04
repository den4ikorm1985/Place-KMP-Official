package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import org.example.placebooker.core.resources.Res

class MainScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold { padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Main Screen - GeoBlinker",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Welcome back!",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
