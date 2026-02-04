package org.example.placebooker

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.placebooker.ui.screens.LoginScreen

@Composable
fun App() {
    MaterialTheme {
        // Navigator — это и есть наш движок переключения экранов. 
        // Первым делом он откроет LoginScreen.
        Navigator(screen = LoginScreen())
    }
}
