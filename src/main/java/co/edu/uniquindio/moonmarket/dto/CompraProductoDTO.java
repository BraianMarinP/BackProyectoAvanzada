package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.Compra;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraProductoDTO {

    @Column(nullable = false)
    @Positive
    private int cantidad;
    @Column(nullable = false)
    private int idPublicacion;
    private int idCompra;
}
