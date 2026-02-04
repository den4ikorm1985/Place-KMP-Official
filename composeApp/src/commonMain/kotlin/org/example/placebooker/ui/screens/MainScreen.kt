package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import org.example.placebooker.core.resources.Res
import org.example.placebooker.ui.main.MainViewModel
import org.example.placebooker.ui.components.PlaceCard

class MainScreen : Screen {
    @Composable
    override fun Content() {
        // Берем мозги у Коина
        val viewModel = getScreenModel<MainViewModel>()
        val places by viewModel.places.collectAsState()

        Scaffold(
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(title = { Text(Res.Strings.APP_NAME) })
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                // Поиск
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(Res.Strings.SEARCH_PLACES) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                )

                // Список карточек
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(places) { place ->
                        PlaceCard(
                            place = place,
                            onClick = { /* В будущем: переход к деталям */ }
                        )
                    }
                }
            }
        }
    }
}
