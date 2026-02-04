package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class SuccessBookingScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                tint = Color(0xFF4CAF50)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Готово!", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Ваше место успешно забронировано", style = MaterialTheme.typography.bodyMedium)
            
            Spacer(modifier = Modifier.height(48.dp))
            
            Button(
                onClick = { navigator.popUntilRoot() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Вернуться на главную")
            }
        }
    }
}
