package com.example.kmpfirstapp.webservices

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.HttpClientEngineConfig
import org.koin.mp.KoinPlatform

expect fun provideHttpClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
