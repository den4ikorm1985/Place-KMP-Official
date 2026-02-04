package org.example.placebooker

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.example.placebooker.ui.auth.LoginScreen
import org.example.placebooker.ui.theme.PlaceBookerTheme

@Composable
fun App() {
    PlaceBookerTheme {
        // Оборачиваем навигатор в SlideTransition для плавности
        Navigator(LoginScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}
