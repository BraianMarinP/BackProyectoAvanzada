package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ComentarioDTO;

public interface ComentarioServicio {

    int crearComentario(ComentarioDTO comentarioDTO) throws Exception;

    int actualizarComentario(ComentarioDTO comentarioDTO) throws Exception;

    int eliminarComentario(ComentarioDTO comentarioDTO) throws Exception;

}
