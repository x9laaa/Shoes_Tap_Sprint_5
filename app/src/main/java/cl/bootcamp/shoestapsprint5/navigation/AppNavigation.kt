package cl.bootcamp.shoestapsprint5.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.shoestapsprint5.view.CarritoView
import cl.bootcamp.shoestapsprint5.view.DetalleProductoView
import cl.bootcamp.shoestapsprint5.view.ListaProductosView
import cl.bootcamp.shoestapsprint5.viewModel.CarritoViewModel
import cl.bootcamp.shoestapsprint5.viewModel.ProductosViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val productosViewModel: ProductosViewModel = viewModel()
    val carritoViewModel: CarritoViewModel = viewModel()


    NavHost(navController, startDestination = "listaProductos") {
        composable("listaProductos") {
            ListaProductosView(navController, productosViewModel, carritoViewModel)
        }
        composable("detalleProducto/{productoId}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId")?.toInt() ?: 0
            DetalleProductoView(navController, productoId, productosViewModel, carritoViewModel)
        }
        composable("carrito") {
            CarritoView(navController, carritoViewModel)
        }

    }
}
