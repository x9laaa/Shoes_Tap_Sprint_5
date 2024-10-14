package cl.bootcamp.shoestapsprint5.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.bootcamp.shoestapsprint5.R
import cl.bootcamp.shoestapsprint5.model.Producto


class ProductosViewModel : ViewModel() {

    private val _productos = MutableLiveData<List<Producto>>()
    val productos: LiveData<List<Producto>> = _productos

    private var currentId = 0

    init {
        _productos.value = listOf(
            Producto(currentId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
            Producto(currentId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
            Producto(currentId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3),
            Producto(currentId++, "Zapatilla Running", 45990.0, R.drawable.zapatilla4),
            Producto(currentId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
            Producto(currentId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
            Producto(currentId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3),
            Producto(currentId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
            Producto(currentId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
            Producto(currentId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3),
            Producto(currentId++, "Zapatilla Running", 45990.0, R.drawable.zapatilla4),
            Producto(currentId++, "Zapato Casual", 29990.0, R.drawable.zapatilla1),
            Producto(currentId++, "Zapato Deportivo", 34990.0, R.drawable.zapatilla2),
            Producto(currentId++, "Zapatilla Urbana", 25990.0, R.drawable.zapatilla3)
        )
    }

    fun obtenerProductoPorId(id: Int): Producto? {
        return _productos.value?.find { it.id == id }
    }


    fun agregarProducto(nombre: String, precio: Double, imagen: Int) {
        val nuevoProducto = Producto(
            id = currentId++,
            nombre = nombre,
            precio = precio,
            imagen = imagen
        )
        _productos.value = _productos.value?.plus(nuevoProducto)
    }
}



