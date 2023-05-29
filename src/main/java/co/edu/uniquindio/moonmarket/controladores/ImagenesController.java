package co.edu.uniquindio.moonmarket.controladores;

import co.edu.uniquindio.moonmarket.dto.ImagenDTO;
import co.edu.uniquindio.moonmarket.dto.MensajeDTO;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CloudinaryServicio;

import co.edu.uniquindio.moonmarket.servicios.interfaces.ImagenServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.Map;
@RestController
@RequestMapping("api/imagenes")
@AllArgsConstructor
public class ImagenesController {
    private final CloudinaryServicio cloudinaryServicio;
    private final ImagenServicio imagenServicio;
    /*@PostMapping("/upload/usuario/{cedula}")
    public ResponseEntity<MensajeDTO> subirImagenUsuario(@RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = cloudinaryServicio.subirImagen(imagen, "proyecto");
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                respuesta ) );
    }*/

    @PostMapping("/upload/usuario/{cedula}")
    public ResponseEntity<MensajeDTO> subirImagenUsuario(@PathVariable String cedula, @RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = imagenServicio.crearImagenUsuario(imagen, cedula);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                respuesta ) );
    }

    @PostMapping("/upload/moderador/{cedula}")
    public ResponseEntity<MensajeDTO> subirImagenModerador(@PathVariable String cedula, @RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        Map respuesta = imagenServicio.crearImagenModerador(imagen, cedula);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                respuesta ) );
    }

    @PostMapping("/upload/publicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO> subirImagenPublicacion(@PathVariable int idPublicacion, @RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        //Map respuesta = imagenServicio.crearImagenProducto(imagen, idPublicacion);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                imagenServicio.crearImagenProducto(imagen, idPublicacion) ) );
    }

    @DeleteMapping
    public ResponseEntity<MensajeDTO> eliminarImagen(@RequestBody ImagenDTO imagenDTO) throws Exception{
        Map respuesta = cloudinaryServicio.eliminarImagen(imagenDTO);
        String idEliminado= imagenServicio.eliminarImagen(imagenDTO.getId());
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, respuesta ) );
    }
}