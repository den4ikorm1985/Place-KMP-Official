package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.placebooker.domain.models.Place
import org.example.placebooker.core.resources.Res

data class DetailsScreen(val place: Place) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(
                    title = { Text(place.name) },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = null)
                        }
                    }
                )
            }
        ) { padding ->
            Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    SuggestionChip(onClick = {}, label = { Text(place.category.name) })
                    SuggestionChip(onClick = {}, label = { Text("⭐ ${place.rating}") })
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Описание", style = MaterialTheme.typography.titleMedium)
                Text(text = place.description, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Адрес", style = MaterialTheme.typography.titleMedium)
                Text(text = place.address, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = { navigator.push(SuccessBookingScreen()) }, modifier = Modifier.fillMaxWidth().height(56.dp)) {
                    Text(Res.Strings.BOOK_NOW)
                }
            }
        }
    }
}
