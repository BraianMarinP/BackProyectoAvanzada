package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.UsuarioDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.moonmarket.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {
    String crearUsuario(UsuarioDTO usuarioDTO) throws Exception;
    String actualizarUsuario(UsuarioGetDTO usuarioGetDTO) throws Exception;
    String eliminiarUsuario(String codigoUsuario) throws Exception;
    UsuarioGetDTO obtenerUsuario(String codigoUsuario) throws Exception;
    List<UsuarioGetDTO> listarUsuarios() throws Exception;
    Usuario obtener(String codigoUsuario) throws Exception;
    String cambiarContrasena(String cedula, String nuevaContrasena) throws Exception;
}
