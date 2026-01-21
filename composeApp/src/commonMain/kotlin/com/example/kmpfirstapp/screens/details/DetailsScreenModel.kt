package com.example.kmpfirstapp.screens.details

import androidx.lifecycle.ViewModel
import com.example.kmpfirstapp.common.fromJsonToOriginal
import com.example.kmpfirstapp.models.ProductsResponseItem

class DetailsViewModel : ViewModel() {

    fun getProduct(product: String): ProductsResponseItem{
        return product.fromJsonToOriginal<ProductsResponseItem>()
    }
}