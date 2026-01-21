package com.example.kmpfirstapp.di

import com.example.kmpfirstapp.webservices.apiClient
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            apiClient
        )
    }
}
