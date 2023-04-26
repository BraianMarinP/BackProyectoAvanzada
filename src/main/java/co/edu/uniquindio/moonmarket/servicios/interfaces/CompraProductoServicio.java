package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.CompraProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.CompraProducto;

public interface CompraProductoServicio {
    int crearCompraProducto(CompraProductoDTO compraProductoDTO) throws Exception;

    CompraProducto obtenerCompraProducto(int idCompraProducto) throws Exception;
}
