package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private float puntuacion;
    private LocalDate fecha;
    private boolean eliminado;

    @ManyToOne
    @JoinColumn(name = "id_publicacion")
    private PublicacionProducto publicacion;

    @ManyToOne
    @JoinColumn(name = "cedula_usuario")
    private Usuario usuario;
}
