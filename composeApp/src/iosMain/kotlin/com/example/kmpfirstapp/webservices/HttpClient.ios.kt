package com.example.kmpfirstapp.webservices

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin
import org.koin.mp.KoinPlatform


actual fun provideHttpClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
    return Darwin
}

