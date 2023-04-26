package co.edu.uniquindio.moonmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailDTO {
    private String asunto;
    private String cuerpo;
    private String destinatario;
}
