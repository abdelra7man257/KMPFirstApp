package com.example.kmpfirstapp.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
@Composable
fun NetworkImageComposable(modifier: Modifier = Modifier, imageUrl: String?,  onLoading:@Composable ()-> Unit = {}, onFailed: @Composable ()-> Unit = {}
){
    if (imageUrl?.isNotEmpty() == true) {
        KamelImage(
        resource = { asyncPainterResource(data = imageUrl) },
        contentDescription = "",
        modifier = modifier.size(200.dp),
            onLoading = {
                onLoading.invoke()
            },
            onFailure = {
                onFailed.invoke()
            }

        )
} else {
    Text("No image")
}
}