package com.example.kmpfirstapp.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kmpfirstapp.composables.NetworkImageComposable
import com.example.kmpfirstapp.composables.ProductItemComposable
import com.example.kmpfirstapp.models.ProductsResponseItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailsScreen(viewModel: DetailsViewModel = koinViewModel() , product: String) {

    val product = viewModel.getProduct(product)
    Surface {
        Column(modifier = Modifier.fillMaxSize() , verticalArrangement = Arrangement.spacedBy(12.dp)) {
            NetworkImageComposable(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f),
                imageUrl = product.image,
                onLoading = {
                    CircularProgressIndicator()
                },
                onFailed = {
                    Text("No Image Found")
                }
            )
            Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Title: ${product.title}" , style = TextStyle(fontSize = MaterialTheme.typography.titleLarge.fontSize , fontWeight = FontWeight.Bold))
                Text(text = "Title: ${product.category}" , style = TextStyle(fontSize = MaterialTheme.typography.titleSmall.fontSize , fontWeight = FontWeight.Bold))
            }
            Text(text = "Title: ${product.price}" , style = TextStyle(fontSize = MaterialTheme.typography.bodyLarge.fontSize , fontWeight = FontWeight.Bold))
            Text(text = "Title: ${product.description}" , style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize))
        }
    }

}