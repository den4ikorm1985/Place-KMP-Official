package org.example.placebooker.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import org.example.placebooker.core.resources.Res

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        // Пока просто текст, использующий наши строки
        Text(text = Res.Strings.WELCOME_TITLE + " в " + Res.Strings.APP_NAME)
    }
}
