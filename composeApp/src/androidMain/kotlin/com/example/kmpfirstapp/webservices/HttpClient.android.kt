package com.example.kmpfirstapp.webservices

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.android.get
import org.koin.compose.koinInject


actual fun provideHttpClientEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
    return OkHttp
}
