package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.Categoria;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDTO {

    private int id;
    private String nombre;
    private String descripcion;
    private List<CategoriaDTO> categorias;
    //private List<PublicacionProductoDTO> publicaciones;


}
