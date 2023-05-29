package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.EstadoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(value = { "contrasena" })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioGetDTO extends PersonaDTO{

    private String nickName;

    //private EstadoUsuario estado;

}
