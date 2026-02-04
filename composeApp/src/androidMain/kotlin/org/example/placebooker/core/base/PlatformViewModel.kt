package org.example.placebooker.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as androidScope
import kotlinx.coroutines.CoroutineScope

actual abstract class PlatformViewModel : ViewModel() {
    actual val viewModelScope: CoroutineScope = androidScope
    actual override fun onCleared() {
        super.onCleared()
    }
}
