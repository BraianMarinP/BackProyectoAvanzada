package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.Producto;

public interface ProductoServicio {
    int crearProducto(ProductoDTO productoDTO) throws Exception;
    int modificarProducto(ProductoDTO productoDTO) throws Exception;
    int eliminarProducto(ProductoDTO productoDTO) throws Exception;
    Producto obtenerProducto(int idProducto) throws Exception;
}
