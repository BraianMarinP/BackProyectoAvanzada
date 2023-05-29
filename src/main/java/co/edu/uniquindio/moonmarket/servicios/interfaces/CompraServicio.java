package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.CompraDTO;
import co.edu.uniquindio.moonmarket.entidades.Compra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO) throws Exception;

    CompraDTO obtenerCompra(int idCompra) throws Exception;

    List<CompraDTO> obtenerComprasUsuario(String cedulaUsuario) throws Exception;

}
