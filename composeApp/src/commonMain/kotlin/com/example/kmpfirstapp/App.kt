package com.example.kmpfirstapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmpfirstapp.composables.ProductItemComposable
import com.example.kmpfirstapp.webservices.getApiClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay

import models.ProductsResponseItem
import org.koin.compose.getKoin
import org.koin.core.Koin

@Composable
@Preview
fun App(
    apiClient: HttpClient = getApiClient()
) {

    var products by remember { mutableStateOf<List<ProductsResponseItem>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            delay(5000)
            products = apiClient.get("/products").body<List<ProductsResponseItem>>()
        } catch (e: Exception) {
            error = e.message
        } finally {
            isLoading = false
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(Modifier.size(100.dp))
            }

            error != null -> {
                Text(
                    text = "Error: $error",
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(vertical = 20.dp)
                ) {
                    items(products) { product ->


                        ProductItemComposable(
                            product = product
                            , onContentImageLoading = {
                                CircularProgressIndicator()
                            },
                            onContentImageFailed = {
                                Text("No Image Found")
                            }
                        )
                    }
                }
            }
        }

    }
}
