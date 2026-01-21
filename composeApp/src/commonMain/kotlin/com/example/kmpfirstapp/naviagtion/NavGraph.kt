package com.example.kmpfirstapp.naviagtion

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import androidx.navigation.toRoute
import com.example.kmpfirstapp.screens.details.DetailsScreen
import com.example.kmpfirstapp.screens.home.HomeScreen
import com.example.kmpfirstapp.screens.routes.Routes

@Composable
fun NavGraph(navController: NavHostController){
    val graph = navController.createGraph(startDestination = Routes.Home)
    {
        composable<Routes.Home> {
            HomeScreen{
                navController.navigate(Routes.Details(it))
            }
        }

        composable<Routes.Details> {
            val args = it.toRoute<Routes.Details>()
            DetailsScreen(product = args.product)
        }
    }
    NavHost(
        navController = navController,
        graph = graph
    )

}