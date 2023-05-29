package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.Comentario;
import co.edu.uniquindio.moonmarket.entidades.Imagen;
import co.edu.uniquindio.moonmarket.entidades.Producto;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicacionProductoDTO {

    private int idPublicacion;
    private String titulo;
    private float precio;
    private int cantidad;
    private List<String> idImagenes;
    private ProductoDTO producto;
    private String creador;

}
