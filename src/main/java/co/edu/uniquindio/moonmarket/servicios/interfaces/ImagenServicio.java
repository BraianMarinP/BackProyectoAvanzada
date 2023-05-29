package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ImagenDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenProductoDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenUsuarioDTO;

import java.io.File;
import java.util.Map;

public interface ImagenServicio {
    Map<String, String> crearImagenUsuario(File imagenSubir, String cedulaUsuario) throws Exception;
    Map<String, String> crearImagenModerador(File imagenSubir, String cedulaModerador) throws Exception;
    String crearImagenProducto(File imagenSubir, int idPublicacion) throws Exception;

    String eliminarImagen(String idIimagen) throws Exception;

}
