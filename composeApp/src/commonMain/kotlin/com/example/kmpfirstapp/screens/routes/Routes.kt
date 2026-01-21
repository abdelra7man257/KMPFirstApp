package com.example.kmpfirstapp.screens.routes

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
sealed interface Routes {

    @Serializable
    object Home : Routes

    @Serializable
    data class Details (val product: String) : Routes
}


