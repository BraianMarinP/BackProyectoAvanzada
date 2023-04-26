package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ImagenModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenProductoDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenUsuarioDTO;

public interface ImagenServicio {
    String crearImagenUsuario(ImagenUsuarioDTO imagenUsuarioDTO) throws Exception;
    String crearImagenModerador(ImagenModeradorDTO imagenModeradorDTO) throws Exception;
    String crearImagenProducto(ImagenProductoDTO imagenProductoDTO) throws Exception;

    String eliminarImagen(String id) throws Exception;

}
