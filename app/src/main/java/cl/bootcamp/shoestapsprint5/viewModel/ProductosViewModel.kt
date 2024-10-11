package cl.bootcamp.shoestapsprint5.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cl.bootcamp.shoestapsprint5.R
import cl.bootcamp.shoestapsprint5.model.Producto


class ProductosViewModel : ViewModel() {

    private var nextId = 1  // Contador para el ID incremental
    val productos = mutableStateListOf(
        Producto(nextId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
        Producto(nextId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
        Producto(nextId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3),
        Producto(nextId++, "Zapatilla Running", 45990.0, R.drawable.zapatilla4),
        Producto(nextId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
        Producto(nextId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
        Producto(nextId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3),
        Producto(nextId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
        Producto(nextId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
        Producto(nextId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3),
        Producto(nextId++, "Zapatilla Running", 45990.0, R.drawable.zapatilla4),
        Producto(nextId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
        Producto(nextId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
        Producto(nextId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3)
    )

    fun agregarProducto(nombre: String, precio: Double, imagenResId: Int) {
        val producto = Producto(id = productos.size+1, nombre = nombre, precio = precio, imagen = imagenResId)
        productos.add(producto)
    }

    fun obtenerProductoPorId(id: Int): Producto? {
        return productos.find { it.id == id }
    }


}
