package com.example.kmpfirstapp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.kmpfirstapp.di.initKoin
import com.example.kmpfirstapp.webservices.apiClient
import com.example.kmpfirstapp.webservices.getApiClient
import io.ktor.client.HttpClient
import org.koin.compose.getKoin
import org.koin.mp.KoinPlatform


fun MainViewController() = ComposeUIViewController(
    configure ={
        initKoin()
    }
) {
    App()
}