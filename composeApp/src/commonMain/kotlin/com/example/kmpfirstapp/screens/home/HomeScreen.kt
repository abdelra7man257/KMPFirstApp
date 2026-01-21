package com.example.kmpfirstapp.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmpfirstapp.common.toJson
import com.example.kmpfirstapp.composables.ProductItemComposable
import com.example.kmpfirstapp.screens.details.DetailsScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(viewModel : HomeViewModel = koinViewModel() , onNavigationClick: (String) -> Unit) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(Modifier.size(100.dp))
            }

            state.error != null -> {
                Text(
                    text = "Error: ${state.error}",
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(vertical = 20.dp)
                ) {
                    items(state.products) { product ->


                        ProductItemComposable(
                            product = product
                            , onContentImageLoading = {
                                CircularProgressIndicator()
                            },
                            onContentImageFailed = {
                                Text("No Image Found")
                            }
                        ){product ->
                            onNavigationClick(product.toJson())
                        }
                    }
                }
            }
        }

    }
}