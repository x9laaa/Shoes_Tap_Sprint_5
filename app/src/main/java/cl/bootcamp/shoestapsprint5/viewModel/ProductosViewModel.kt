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
            Producto(currentId++, "Zapatilla Running Pro", 45990.0, R.drawable.zapatilla1),
            Producto(currentId++, "Zapatilla Casual Vintage", 32990.0, R.drawable.zapatilla2),
            Producto(currentId++, "Zapatilla Deportiva Light", 28990.0, R.drawable.zapatilla3),
            Producto(currentId++, "Zapatilla Urbana Trend", 39990.0, R.drawable.zapatilla4),
            Producto(currentId++, "Zapatilla Montaña Extreme", 54990.0, R.drawable.zapatilla5),
            Producto(currentId++, "Zapatilla Fitness Dynamic", 37990.0, R.drawable.zapatilla6),
            Producto(currentId++, "Zapatilla Skate Classic", 26990.0, R.drawable.zapatilla7),
            Producto(currentId++, "Zapatilla Trail Explorer", 49990.0, R.drawable.zapatilla8),
            Producto(currentId++, "Zapatilla Running Ultra", 59990.0, R.drawable.zapatilla9)
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



