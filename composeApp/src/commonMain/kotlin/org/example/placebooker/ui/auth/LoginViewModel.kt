package org.example.placebooker.ui.auth

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.example.placebooker.core.logic.Validator

class LoginViewModel {
    // Состояние полей ввода
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    
    // Состояние ошибки
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun onLoginClick(onSuccess: () -> Unit) {
        val currentEmail = email.value
        val currentPassword = password.value

        if (!Validator.isValidEmail(currentEmail)) {
            _error.value = "Неверный формат почты"
            return
        }

        if (!Validator.isValidPassword(currentPassword)) {
            _error.value = "Пароль слишком короткий"
            return
        }

        // Если всё ок — сбрасываем ошибку и заходим
        _error.value = null
        onSuccess()
    }
}
