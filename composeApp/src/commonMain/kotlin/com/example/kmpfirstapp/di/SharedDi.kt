package com.example.kmpfirstapp.di

import com.example.kmpfirstapp.screens.details.DetailsViewModel
import com.example.kmpfirstapp.screens.home.HomeViewModel
import com.example.kmpfirstapp.webservices.apiClient
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import org.koin.mp.KoinPlatform.getKoin

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            apiClient,
            viewModel
        )
    }
}

val viewModel = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailsViewModel)
}
