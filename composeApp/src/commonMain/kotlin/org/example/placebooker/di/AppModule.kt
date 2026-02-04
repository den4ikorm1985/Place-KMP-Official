package org.example.placebooker.di

import org.koin.dsl.module
import org.example.placebooker.domain.repository.PlaceRepository
import org.example.placebooker.ui.auth.LoginViewModel
import org.example.placebooker.ui.main.MainViewModel
import org.example.placebooker.presentation.features.details.DetailsViewModel

val appModule = module {
    // Singletons (Репозитории)
    single { PlaceRepository() }

    // ViewModels (Регистрируем как factory, чтобы создавались при входе на экран)
    factory { LoginViewModel() }
    factory { MainViewModel(get()) }
    factory { DetailsViewModel(get()) }
}
