package com.example.kmpfirstapp.webservices

// commonMain
import io.ktor.client.*
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.koin.mp.KoinPlatform
import org.koin.mp.KoinPlatform.getKoin


val apiClient = module {
    single {
        HttpClient(provideHttpClientEngine()) {

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                        prettyPrint = false
                    }
                )
            }
            expectSuccess = true

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "fakestoreapi.com"
                }
            }
            install(DefaultRequest) {
                header(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }
    }
}


