package org.example.placebooker.core.di

import org.example.placebooker.ui.auth.LoginViewModel
import org.example.placebooker.ui.main.MainViewModel
import org.example.placebooker.domain.repository.PlaceRepository
import org.koin.dsl.module

val appModule = module {
    single { PlaceRepository() } // Репозиторий создается в единственном экземпляре
    factory { LoginViewModel() }
    factory { params -> MainViewModel(get()) } // Передаем репозиторий во ViewModel
}
