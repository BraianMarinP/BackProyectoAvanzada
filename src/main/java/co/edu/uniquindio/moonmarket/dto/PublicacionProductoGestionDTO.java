package co.edu.uniquindio.moonmarket.dto;

import co.edu.uniquindio.moonmarket.entidades.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicacionProductoGestionDTO {
    private String titulo;
    private boolean eliminado;
    private int precio;
    private EstadoPublicacion estado;
    private int cantidad;
    private List<ImagenProductoDTO> imagenes;
    private List<Comentario> comentarios;
    private Producto producto;
    private Usuario creador;
    private LocalDateTime fechaLimite;
}
