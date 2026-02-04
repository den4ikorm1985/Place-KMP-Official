package org.example.placebooker.core.base

import kotlinx.coroutines.CoroutineScope

expect abstract class PlatformViewModel() {
    val viewModelScope: CoroutineScope
    protected open fun onCleared()
}
