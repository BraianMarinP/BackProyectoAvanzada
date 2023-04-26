package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.CompraDTO;
import co.edu.uniquindio.moonmarket.entidades.Compra;

import java.util.HashMap;
import java.util.List;

public interface CompraServicio {

    int crearCompra(CompraDTO compraDTO, HashMap<Integer, Integer> publicacionUnidades ) throws Exception;

    CompraDTO obtenerCompra(int idCompra) throws Exception;

    List<CompraDTO> obtenerComprasUsuario(String cedulaUsuario) throws Exception;

}
