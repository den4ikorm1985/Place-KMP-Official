package org.example.placebooker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class BookingCalendarScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val datePickerState = rememberDatePickerState()
        val isDateSelected = datePickerState.selectedDateMillis != null

        Scaffold { padding ->
            Column(Modifier.fillMaxSize().padding(padding)) {
                DatePicker(state = datePickerState, modifier = Modifier.weight(1f))
                Button(
                    onClick = { navigator.push(SuccessBookingScreen()) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isDateSelected // Кнопка активна только если дата выбрана
                ) {
                    Text(if (isDateSelected) "Подтвердить дату" else "Выберите дату")
                }
            }
        }
    }
}
