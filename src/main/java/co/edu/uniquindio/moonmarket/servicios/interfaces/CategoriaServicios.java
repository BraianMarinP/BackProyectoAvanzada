package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.CategoriaDTO;
import co.edu.uniquindio.moonmarket.entidades.Categoria;

public interface CategoriaServicios {
    int crearCategoria(CategoriaDTO categoriaDTO) throws Exception;

    int actualizarCategoria(String nombreViejo, String nombreNuevo) throws Exception;

    Categoria obtenerCategoria(int idCategoria) throws Exception;
}
