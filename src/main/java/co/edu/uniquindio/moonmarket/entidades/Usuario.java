package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "nickName"))
@NoArgsConstructor
@Getter
@Setter

public class Usuario extends Persona implements Serializable {

    @Column(nullable = false)
    private String nickName;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "creador")

    private List<PublicacionProducto> publicaciones;

    @OneToOne(mappedBy = "usuario")
    private Imagen imagen;

    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;

    @ManyToMany(cascade = { CascadeType.REMOVE }, mappedBy = "favoriteros", fetch=FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<PublicacionProducto> favoritos;


}
