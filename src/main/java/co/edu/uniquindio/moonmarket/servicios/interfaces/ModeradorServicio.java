package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ModeradorGetDTO;
import co.edu.uniquindio.moonmarket.entidades.Moderador;

public interface ModeradorServicio {

    String actualizarModerador(String cedula, ModeradorGetDTO moderadorDTO) throws Exception;

    ModeradorDTO buscarModerador(String cedulaModerador) throws Exception;

    String cambiarContrasena(String cedula, String nuevaContrasena) throws Exception;

}

