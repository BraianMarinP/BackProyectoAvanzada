package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Imagen implements Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private String id;
    @Id
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_publicacion")
    private PublicacionProducto publicacion;

    @OneToOne
    @JoinColumn(name = "cedula_moderador")
    private Moderador moderador;

    @OneToOne
    @JoinColumn(name = "cedula_usuario")
    private Usuario usuario;

}
