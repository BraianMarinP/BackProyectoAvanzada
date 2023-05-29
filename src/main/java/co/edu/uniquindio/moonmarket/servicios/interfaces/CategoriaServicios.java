package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.CategoriaDTO;
import co.edu.uniquindio.moonmarket.entidades.Categoria;

import java.util.List;

public interface CategoriaServicios {
    int crearCategoria(CategoriaDTO categoriaDTO) throws Exception;
    int actualizarCategoria(String nombreViejo, String nombreNuevo) throws Exception;
    Categoria obtenerCategoria(int idCategoria) throws Exception;
    List<Object[]> cantidadProductosCategoria();

    List<CategoriaDTO> listarCategorias () throws Exception;
}
