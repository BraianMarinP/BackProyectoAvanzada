package co.edu.uniquindio.moonmarket.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class UsuarioDTO extends PersonaDTO {
    private String nickName;

    @Builder
    public UsuarioDTO(String cedula, String numTel, String direccion, String nombre, String email, String contrasena, String nickName) {
        super(cedula, numTel, direccion, nombre, email, contrasena);
        this.nickName = nickName;
    }
}
