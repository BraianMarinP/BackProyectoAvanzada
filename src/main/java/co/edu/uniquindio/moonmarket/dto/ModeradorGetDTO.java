package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.Imagen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(value = { "contrasena" })

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeradorGetDTO extends PersonaDTO{
    private Imagen imagen;

}
