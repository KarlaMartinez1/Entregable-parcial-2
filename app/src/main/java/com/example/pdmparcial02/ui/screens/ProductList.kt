package com.example.pdmparcial02.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.grid.*
import com.example.pdmparcial02.ProductViewModel
import com.example.pdmparcial02.ui.components.ProductCard

@Composable
fun ProductListScreen(navController: NavController, viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.filteredProducts
    val query by viewModel.searchQuery

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = viewModel::onSearchQueryChanged,
            label = { Text("Buscar por nombre o categoria") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(products) { product ->
                ProductCard(product = product) {
                    navController.navigate("detail/${product.id}")
                }
            }
        }
    }
}