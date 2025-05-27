package com.example.pdmparcial02

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.pdmparcial02.ui.screens.ProductDetailScreen
import com.example.pdmparcial02.ui.screens.ProductListScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {
        composable("list") { ProductListScreen(navController) }
        composable(
            "detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            ProductDetailScreen(productId)
        }
    }
}