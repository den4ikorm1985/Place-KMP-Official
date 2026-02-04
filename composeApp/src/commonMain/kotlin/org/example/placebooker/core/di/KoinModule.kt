package org.example.placebooker.core.di

import org.example.placebooker.ui.auth.LoginViewModel
import org.example.module
import org.koin.dsl.module

val appModule = module {
    // Говорим Коину: "Когда кто-то попросит LoginViewModel, создай новый экземпляр"
    factory { LoginViewModel() }
}
