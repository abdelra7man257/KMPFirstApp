package com.example.kmpfirstapp.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpfirstapp.models.ProductsResponseItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val apiClient: HttpClient
): ViewModel() , HomeViewModelContract {

    private val _state = MutableStateFlow(HomeViewModelContract.States())
    override val state: StateFlow<HomeViewModelContract.States>
        get() = _state.asStateFlow()

    init {
        executeAction(HomeViewModelContract.Actions.GetAllProducts)
    }

    override fun executeAction(action: HomeViewModelContract.Actions) {
        when(action){
            is HomeViewModelContract.Actions.GetAllProducts -> {
                getAllProducts()
            }
        }
    }

    private fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                _state.update {
                    it.copy(isLoading = true)
                }
                apiClient.get("/products").body<List<ProductsResponseItem>>()
            }.onSuccess {response ->
                _state.update {
                    it.copy(isLoading = false, products = response)
                }
            }.onFailure {
                _state.update {
                    it.copy(isLoading = false, error = it.error)
                }
            }
        }
    }


}