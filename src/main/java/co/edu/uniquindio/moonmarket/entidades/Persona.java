package co.edu.uniquindio.moonmarket.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@MappedSuperclass
@Getter
@Setter
public class Persona implements Serializable {
    @Id
    @Size(min=7, max = 10, message ="La cédula debe tener entre 7 y 10 caracteres" )
    protected String cedula;
    @Size(min=10, max = 10, message ="El número debe tener mínimo 10 dígitos")
    protected String numTel;
    @Column(nullable = false)
    protected String direccion;
    @Column(nullable = false, length = 100)
    protected String nombre;
    @Email(message = "Por favor, proporcione un correo electrónico válido")
    protected String email;
    //@Size(min = 8, max = 50, message = "La contraseña debe tener entre 8 y 50 caracteres")
   // @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "La contraseña debe contener al menos 8 caracteres, al menos una letra mayúscula o minúscula y al menos un número")
    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar vacía")
    protected String contrasena;




}
