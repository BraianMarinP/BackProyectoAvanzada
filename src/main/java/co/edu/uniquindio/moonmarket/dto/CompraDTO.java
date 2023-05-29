package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.CompraProducto;
import co.edu.uniquindio.moonmarket.entidades.MedioPago;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraDTO {
    private float valorTotal;
    private MedioPago medioPago;
    private List<CompraProductoDTO> productos;
    private String codigoUsuario;
    private LocalDate fecha;


}
