package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.placebooker.core.resources.Res
import org.example.placebooker.ui.main.MainViewModel
import org.example.placebooker.ui.components.*

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<MainViewModel>()
        val navigator = LocalNavigator.currentOrThrow
        val places by viewModel.places.collectAsState()
        val searchText by viewModel.searchQuery.collectAsState()
        val selectedCategory by viewModel.selectedCategory.collectAsState()
        val isSorted by viewModel.sortByRating.collectAsState()

        Scaffold(
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(
                    title = { Text(Res.Strings.APP_NAME) },
                    actions = {
                        Text("ТОП", style = MaterialTheme.typography.labelSmall)
                        Switch(checked = isSorted, onCheckedChange = { viewModel.sortByRating.value = it })
                        IconButton(onClick = { navigator.push(ProfileScreen()) }) { Icon(Icons.Default.Person, null) }
                    }
                )
            }
        ) { padding ->
            Column(modifier = Modifier.fillMaxSize().padding(padding).padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { viewModel.searchQuery.value = it },
                    label = { Text(Res.Strings.SEARCH_PLACES) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                )
                FilterBar(selectedCategory = selectedCategory, onCategorySelected = { viewModel.selectedCategory.value = it })
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(places) { place -> PlaceCard(place = place, onClick = { navigator.push(DetailsScreen(place)) }) }
                }
            }
        }
    }
}
