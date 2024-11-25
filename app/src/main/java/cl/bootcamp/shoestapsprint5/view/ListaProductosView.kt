package cl.bootcamp.shoestapsprint5.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.shoestapsprint5.R
import cl.bootcamp.shoestapsprint5.components.AppBarView
import cl.bootcamp.shoestapsprint5.components.NavigationBarSample
import cl.bootcamp.shoestapsprint5.viewModel.CarritoViewModel
import cl.bootcamp.shoestapsprint5.viewModel.ProductosViewModel


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ListaProductosView(navController: NavController, productosViewModel: ProductosViewModel, carritoViewModel: CarritoViewModel) {
    val productos = productosViewModel.productos.value ?: emptyList()
    val totalArticulosCarrito = carritoViewModel.carrito.value?.sumOf { it.cantidad } ?: 0

    Scaffold(
        topBar = {
            AppBarView(stringResource(R.string.app_name))
        },
        bottomBar = {
            NavigationBarSample(navController, totalArticulosCarrito) // Pasa el total de artículos al carrito
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues) // Asegura que el contenido esté debajo de la TopAppBar
                .padding(2.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(vertical = 8.dp),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productos) { producto ->
                    ProductoCard(
                        producto = producto,
                        onClick = {
                            navController.navigate("detalleProducto/${producto.id}")
                        }
                    )
                }
            }
        }
    }
}