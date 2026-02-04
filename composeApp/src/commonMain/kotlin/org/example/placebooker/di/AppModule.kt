package org.example.placebooker.di

import org.koin.dsl.module

// Здесь будут жить все зависимости нашего приложения
val appModule = module {
    
    // 1. Сетевой слой (Ktor) - добавим позже
    
    // 2. База данных (SQLDelight) - добавим позже
    
    // 3. ViewModels (по одной для каждого из 24 модулей)
    // factory { LoginViewModel(get()) }
}

// Функция для инициализации Koin на разных платформах
fun initKoin(appDeclaration: () -> Unit = {}) {
    // Эта функция будет вызываться в Android (MainActivity) и iOS (MainViewController)
}
