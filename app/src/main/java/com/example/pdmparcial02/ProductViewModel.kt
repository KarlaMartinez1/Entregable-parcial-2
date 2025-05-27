package com.example.pdmparcial02

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pdmparcial02.model.Product

class ProductViewModel: ViewModel(){

        private val _searchQuery = mutableStateOf("")
        val searchQuery: State<String> = _searchQuery

        private val pets = listOf(
            Product(1, "Shampoo", "higiene ", 2.50, "Aroma suave", R.drawable.ic_launcher_background, true),
            Product(2, "jabon", "higiene personal", 1.75, "Aroma suave", R.drawable.ic_launcher_background, false),
            Product(3, "acondicionador", "higiene ", 2.80, "Aroma suave", R.drawable.ic_launcher_background, true),
            Product(4, "esponja de banio", "higiene personal", 1.15, "Aroma suave", R.drawable.ic_launcher_background, false),
            Product(5, "gel de banio", "higiene personal", 2.60, "Aroma suave", R.drawable.ic_launcher_background, true)

        )

        val filteredProducts: State<List<Product>> = derivedStateOf{
            if (_searchQuery.value.isBlank()) pets
            else pets.filter {
                it.name.contains(_searchQuery.value, ignoreCase = true) || it.categories.contains(_searchQuery.value, ignoreCase = true)
            }
        }

        fun onSearchQueryChanged(query: String) {
            _searchQuery.value = query
        }

        fun getProductById(id: Int): Product? = pets.find { it.id == id }
    }
