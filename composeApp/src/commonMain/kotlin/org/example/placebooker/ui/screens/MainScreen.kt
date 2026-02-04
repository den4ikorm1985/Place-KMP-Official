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
import org.example.placebooker.ui.components.FilterBar

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<MainViewModel>()
        val places by viewModel.places.collectAsState(emptyList())
        val selectedCategory by viewModel.selectedCategory.collectAsState()

        Scaffold(
            topBar = { @OptIn(ExperimentalMaterial3Api::class) TopAppBar(title = { Text(Res.Strings.APP_NAME) }) }
        ) { padding ->
            Column(modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp)) {
                // ПАНЕЛЬ ФИЛЬТРОВ
                FilterBar(
                    selectedCategory = selectedCategory,
                    onCategorySelected = { viewModel.selectedCategory.value = it }
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(places) { place ->
                        PlaceCard(place = place, onClick = { /* Детали */ })
                    }
                }
            }
        }
    }
}
