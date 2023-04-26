package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fecha;
    private float valorTotal;

    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> productos;

    @ManyToOne
    private Usuario usuario;


}
