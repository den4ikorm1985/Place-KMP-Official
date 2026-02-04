package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.example.placebooker.core.resources.Res
import org.example.placebooker.ui.auth.LoginViewModel

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<LoginViewModel>()
        val navigator = LocalNavigator.currentOrThrow // Получаем доступ к навигатору
        
        val email by viewModel.email.collectAsState()
        val password by viewModel.password.collectAsState()
        val error by viewModel.error.collectAsState()

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = Res.Strings.WELCOME_TITLE, style = MaterialTheme.typography.headlineMedium)
            
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.email.value = it },
                label = { Text(Res.Strings.EMAIL) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.password.value = it },
                label = { Text(Res.Strings.PASSWORD) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            error?.let {
                Text(text = it, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 8.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { 
                    viewModel.onLoginClick {
                        // Если валидация прошла — летим на главный экран!
                        navigator.push(MainScreen())
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(Res.Strings.LOGIN)
            }
        }
    }
}
