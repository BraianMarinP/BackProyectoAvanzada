package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.SesionDTO;
import co.edu.uniquindio.moonmarket.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO dto) throws Exception;
   // logout(int codigoUsuario);
}
