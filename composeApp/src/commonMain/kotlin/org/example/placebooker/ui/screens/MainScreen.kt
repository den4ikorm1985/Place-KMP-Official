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
import kotlinx.coroutines.launch
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
        
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(
                    title = { Text(Res.Strings.APP_NAME) },
                    actions = {
                        Text("ТОП", style = MaterialTheme.typography.labelSmall)
                        Switch(checked = isSorted, onCheckedChange = { val valNew = it; viewModel.sortByRating.value = valNew; scope.launch { snackbarHostState.showSnackbar(if(valNew) "Показываем только лучшие места" else "Показываем все места") } })
                        IconButton(onClick = { navigator.push(ProfileScreen()) }) { Icon(Icons.Default.Person, null) }
                    }
                )
            }
        ) { padding ->
            Column(modifier = Modifier.fillMaxSize().padding(padding)) { ProjectStatusBar(currentMessage = 107); Spacer(Modifier.height(8.dp)); Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { viewModel.searchQuery.value = it },
                    label = { Text(Res.Strings.SEARCH_PLACES) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
# 1. Заходим в проект
cd /storage/emulated/0/Documents/GeoBlinker_WORKSPACE/PLACE_OFFICIAL/

# 2. Создаем экран карты (заглушка с координатами)
cat <<'EOF' > composeApp/src/commonMain/kotlin/org/example/placebooker/ui/screens/MapScreen.kt
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
        Scaffold(
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(
                    title = { Text("Карта мест") },
                    navigationIcon = {
                        IconButton(onClick = { navigator.pop() }) { Icon(Icons.Default.ArrowBack, null) }
                    }
                )
            }
        ) { padding ->
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text("Здесь будет карта Пойковского с метками")
            }
        }
    }
}
