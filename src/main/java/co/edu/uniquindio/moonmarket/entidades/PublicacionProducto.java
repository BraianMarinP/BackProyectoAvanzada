package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class PublicacionProducto implements Serializable {

    //Dos llaves foráneas
    @OneToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "cedula_creador")
    @JsonBackReference
    private Usuario creador;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacionProducto;

    @Enumerated(EnumType.STRING)
    private EstadoPublicacion estado;

    private String titulo;
    private boolean eliminado;
    private float precio;
    private LocalDateTime fechaLimite;
    private int cantidad;

    @OneToMany(mappedBy = "publicacion")

    private List<Imagen> imagenes;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "publicacion")
    private List<CompraProducto> listaCompraProductos;

    //Este relacion es que se puede agregar una publicacion como favorito
    @ManyToMany(cascade = { CascadeType.DETACH }, fetch=FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "producto_favorito",
            joinColumns = @JoinColumn(name = "id_publicacion"),
            inverseJoinColumns = @JoinColumn(name = "cedula_usuario"))
    private List<Usuario> favoriteros;

    @Override
    public String toString() {
        return "PublicacionProducto{" +
                "idPublicacionProducto=" + idPublicacionProducto +
                ", estado=" + estado +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                '}';
    }
}
