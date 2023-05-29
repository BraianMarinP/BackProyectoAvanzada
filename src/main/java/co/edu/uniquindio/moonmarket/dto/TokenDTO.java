package co.edu.uniquindio.moonmarket.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
    @NotNull
    private String token;
    //Especificado en la guia 19 casi al final
    private String refreshToken;
}