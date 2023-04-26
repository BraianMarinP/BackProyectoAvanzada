package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Moderador extends Persona implements Serializable {
    @OneToOne(mappedBy = "moderador")
    private Imagen imagen;
}
