package com.example.pdmparcial02.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pdmparcial02.ProductViewModel

@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductViewModel = viewModel()) {
    val product = viewModel.getProductById(productId)

    product?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = it.image),
                contentDescription = it.name,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = it.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = "categoria: ${it.categories}")
            Text(text = "precio: ${it.price}")
            Text(text = "Descripción: ${it.description}")

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {}) { Text("agregar al carrito") }
        }
    } ?: Text("producto no encontrado.")
}