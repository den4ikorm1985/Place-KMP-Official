package org.example.placebooker

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.placebooker.core.di.appModule
import org.example.placebooker.ui.screens.LoginScreen
import org.koin.compose.KoinApplication

@Composable
fun App() {
    // Запускаем Koin внутри Compose
    KoinApplication(application = {
        modules(appModule)
    }) {
        MaterialTheme {
            Navigator(screen = LoginScreen())
        }
    }
}
