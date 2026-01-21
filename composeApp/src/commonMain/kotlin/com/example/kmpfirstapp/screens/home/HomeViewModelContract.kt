package com.example.kmpfirstapp.screens.home

import androidx.compose.runtime.Stable
import com.example.kmpfirstapp.models.ProductsResponseItem
import kotlinx.coroutines.flow.StateFlow

interface HomeViewModelContract {

    val state: StateFlow<States>
    fun executeAction(action: Actions)


    @Stable
    data class States(
        val isLoading: Boolean = false,
        val products: List<ProductsResponseItem> = emptyList(),
        val error: String? = null
    )

    sealed class Actions {
        object GetAllProducts : Actions()
    }

}