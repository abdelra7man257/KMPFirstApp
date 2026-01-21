package com.example.kmpfirstapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import models.ProductsResponseItem

@Composable
fun ProductItemComposable(
    modifier: Modifier = Modifier,
    product: ProductsResponseItem?,
    onContentImageLoading: @Composable ()-> Unit={},
    onContentImageFailed: @Composable ()-> Unit={}
) {

    if (product!=null){
        Row(modifier = modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
            NetworkImageComposable(
                imageUrl = product.image, onLoading = {
                    onContentImageLoading.invoke()
                },
                onFailed = {
                    onContentImageFailed.invoke()
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .safeContentPadding()
            ) {
                Text(text = product.title?:"")
                Text(text = "${product.price}$")
            }
        }
    }else{

        Box (
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ){
            Text("No Data Found for this product")
        }
    }
}