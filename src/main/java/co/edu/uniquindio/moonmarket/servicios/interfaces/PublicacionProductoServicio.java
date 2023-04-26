package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.PublicacionProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.EstadoPublicacion;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;

import java.util.List;

public interface PublicacionProductoServicio {
    int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, String cedulaCreador, int idProducto) throws Exception;
    PublicacionProducto obtenerPublicacionProducto(int idPublicacion) throws Exception;
    List<PublicacionProducto> obtenerPublicacionesUsuario(String cedulaUsuario) throws Exception;
    int actualizarPublicacionProducto(PublicacionProductoDTO publicacionProducto, int idPublicacion, int idProducto) throws Exception;
    int eliminarPublicacionProducto(int idPublicacion) throws Exception;
    int alternarEstadoPublicacion(EstadoPublicacion estadoPublicacion, int idPublicacion) throws Exception;
    List<PublicacionProductoDTO> listarPublicacionesEstado(EstadoPublicacion estadoPublicacion) throws Exception;
    List<PublicacionProductoDTO> listarPublicaciones() throws Exception;
    List<PublicacionProductoDTO> listarPublicacionesCategoria(String nombreCategoria) throws Exception;
    List<PublicacionProductoDTO> listarPublicacionesUsuario(String cedulaUsuario) throws Exception;
    List<PublicacionProductoDTO> listarPublicacionesFavoritas(String cedulaUsuario) throws Exception;
    List<PublicacionProductoDTO> buscarPublicaciones(String nombreProducto) throws Exception;

    int agregarPublicacionAFavoritos(String cedulaUsuario, int idPublicacion) throws Exception;
    int eliminarPublicacionDeFavoritos(String cedulaUsuario, int idPublicacion) throws Exception;

}
