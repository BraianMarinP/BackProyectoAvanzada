package co.edu.uniquindio.moonmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompraRequestDTO {
        private CompraDTO compraDTO;
        private Map<Integer, Integer> unidadesProducto;


}
