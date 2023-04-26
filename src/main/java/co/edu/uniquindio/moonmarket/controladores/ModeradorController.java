package co.edu.uniquindio.moonmarket.controladores;

import co.edu.uniquindio.moonmarket.dto.*;
import co.edu.uniquindio.moonmarket.entidades.EstadoPublicacion;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/moderadores")
@AllArgsConstructor
public class ModeradorController {
    private ModeradorServicio moderadorServicio;
    private PublicacionProductoServicio publicacionProductoServicio;

    @GetMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> obtener(@PathVariable String codigo) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, moderadorServicio.buscarModerador(codigo) ));
    }


    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<MensajeDTO> actualizar(@PathVariable String codigo, @Valid @RequestBody ModeradorGetDTO moderador) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                moderadorServicio.actualizarModerador(codigo,moderador) ) );
    }


    @PutMapping("/cambiarCon/{codigo}")
    public ResponseEntity<MensajeDTO> cambiarContrasena(@PathVariable String codigo, @RequestParam String nuevaContrasena ) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                moderadorServicio.cambiarContrasena(codigo,nuevaContrasena) ) );
    }

    @PutMapping("/cambiarEstado/{idPublicacion}/{estado}")
    public ResponseEntity<MensajeDTO> cambiarEstado(@PathVariable int idPublicacion, @PathVariable String estado ) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                publicacionProductoServicio.alternarEstadoPublicacion(EstadoPublicacion.valueOf(estado),idPublicacion) ) );
    }

    @GetMapping("/listarEstado/{estado}")
    public ResponseEntity<MensajeDTO> listarEstado(@PathVariable String estado ) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                publicacionProductoServicio.listarPublicacionesEstado(EstadoPublicacion.valueOf(estado)) ) );
    }
}
