package org.example.placebooker.core.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<S, E, F>(initialState: S) {
    
    // Область видимости для корутин (автоматически очищается при уничтожении)
    protected val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()
    
    private val _effects = MutableSharedFlow<F>()
    val effects = _effects.asSharedFlow()
    
    // Главная точка входа для всех событий экрана
    abstract fun onEvent(event: E)
    
    protected fun updateState(transform: (S) -> S) {
        _state.value = transform(_state.value)
    }

    protected fun sendEffect(effect: F) {
        scope.launch { _effects.emit(effect) }
    }

    // Метод для очистки ресурсов (вызывается платформой)
    fun clear() {
        scope.cancel()
    }
}
