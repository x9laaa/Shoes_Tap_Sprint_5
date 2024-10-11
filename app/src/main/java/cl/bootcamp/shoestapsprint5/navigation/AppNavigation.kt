package cl.bootcamp.shoestapsprint5.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.shoestapsprint5.view.DetalleProductoView
import cl.bootcamp.shoestapsprint5.view.ListaProductosView

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "listaProductos") {
        composable("listaProductos") {
            ListaProductosView(navController)
        }
        composable("detalleProducto/{productoId}") { backStackEntry ->
            val productoId = backStackEntry.arguments?.getString("productoId")?.toInt()
            productoId?.let {
                DetalleProductoView(navController, productoId)
            }
        }
    }
}