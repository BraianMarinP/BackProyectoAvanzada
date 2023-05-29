package co.edu.uniquindio.moonmarket.controladores;

import co.edu.uniquindio.moonmarket.dto.MensajeDTO;
import co.edu.uniquindio.moonmarket.dto.SesionDTO;
import co.edu.uniquindio.moonmarket.dto.TokenDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioDTO;
import co.edu.uniquindio.moonmarket.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final UsuarioServicio usuarioServicio;
    private final SesionServicio sesionServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@Valid @RequestBody SesionDTO loginUser) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                sesionServicio.login(loginUser)) );
    }
    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> registrarCliente(@Valid @RequestBody UsuarioDTO usuario) throws Exception {
        usuarioServicio.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, "Cliente creado correctamente"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<MensajeDTO> refrescarToken(@Valid @RequestBody TokenDTO tokenDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(HttpStatus.CREATED,
                false, sesionServicio.refreshToken(tokenDTO)));
    }
}