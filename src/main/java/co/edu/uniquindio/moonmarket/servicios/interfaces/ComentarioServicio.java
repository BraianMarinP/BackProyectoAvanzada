package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioServicio {


    List<ComentarioDTO> listarComentarios(int idPublicacion) throws  Exception;
    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    int actualizarComentario(ComentarioDTO comentarioDTO) throws Exception;

    int eliminarComentario(ComentarioDTO comentarioDTO) throws Exception;

}
