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
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.kmpfirstapp.screens.routes.Routes
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.kmpfirstapp.common.fromJsonToOriginal
import com.example.kmpfirstapp.models.ProductsResponseItem
import com.example.kmpfirstapp.naviagtion.NavGraph
import com.example.kmpfirstapp.screens.details.DetailsScreen
import com.example.kmpfirstapp.screens.home.HomeScreen


@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    NavGraph(
        navController,
    )

}
